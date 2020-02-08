package com.xjw.service.order.impl;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.common.util.Constant;
import com.xjw.dao.order.WithdrawalOrderDao;
import com.xjw.entity.po.log.UserAccountIntegralChangeLog;
import com.xjw.entity.po.order.WithdrawalOrder;
import com.xjw.entity.po.sys.Function;
import com.xjw.entity.po.sys.UserBankInfo;
import com.xjw.entity.po.user.AccountIntegral;
import com.xjw.entity.po.user.User;
import com.xjw.kzenum.log.AccountIntegralChangeLogTypeEnum;
import com.xjw.kzenum.notice.NoticeCodeEnum;
import com.xjw.kzenum.user.UserTypeAllEnum;
import com.xjw.service.log.UserAccountIntegralChangeLogService;
import com.xjw.service.notice.NoticeService;
import com.xjw.service.order.WithdrawalOrderService;
import com.xjw.service.sys.FunctionService;
import com.xjw.service.sys.UserBankInfoService;
import com.xjw.service.user.UserAccountIntegralService;
import com.xjw.service.user.UserService;
import com.xjw.util.SequenceBuilder;
import com.xjw.util.SequenceBuilder.SequenceType;
import com.xjw.utility.BizException;
import com.xjw.utility.ContextUrlManager;
import com.xjw.utility.DataMath;

@Service
public class WithdrawalOrderServiceImpl extends BaseServiceImpl<WithdrawalOrder> implements WithdrawalOrderService {

    /** 最低提款额度 */
    private static final BigDecimal MIN_AMOUNT = BigDecimal.valueOf(50);

    @Autowired
    private WithdrawalOrderDao withdrawalOrderDao;
    @Autowired
    private UserAccountIntegralService userAccountIntegralService;
    @Autowired
    private UserAccountIntegralChangeLogService userAccountIntegralChangeLogService;
    @Autowired
    private UserBankInfoService userBankInfoService;
    @Autowired
    private UserService userService;
    @Autowired
    private FunctionService functionService;
    @Autowired
    private NoticeService noticeService;

    public WithdrawalOrder createOrder(User user, Long userBankId, BigDecimal amount, String remark)
            throws BizException, Exception {
        if (null == user) {
            throw new BizException("用户不能为空");
        } else if (null == amount || MIN_AMOUNT.compareTo(amount) > 0) {
            throw new BizException("提款金额不能少于50元");
        } else if (userBankId == null || userBankId < 0) {
            throw new BizException("提款未选择银行卡");
        }

        AccountIntegral accountIntegral = userAccountIntegralService.selectByUserId(user.getId());
        if (null == accountIntegral || amount.compareTo(accountIntegral.getTotalMoney()) > 0) {
            throw new BizException("您的可提款余额不足");
        }

        UserBankInfo userBank = userBankInfoService.selectById(userBankId);
        if (null == userBank || !userBank.getUserId().equals(user.getId())) {
            throw new BizException("您的银行卡不存在");
        }

        Calendar nowTime = Calendar.getInstance();

        // 保存 提款申请订单
        WithdrawalOrder order = new WithdrawalOrder();
        order.setUserId(user.getId());
        order.setTradeAmount(amount);
        order.setOrderNo(SequenceBuilder.next(SequenceType.WD));
        order.setToBankType(userBank.getBankType());
        order.setToBankAccount(userBank.getAccountName());
        order.setToBankCard(userBank.getBankCardNo());
        order.setToBankAddress(userBank.getBankAddress());
        order.setRemark(remark);
        order.setCreateTime(nowTime.getTime());
        this.save(order);

        // 修改银行卡默认选中状态
        UserBankInfo _ubi = new UserBankInfo();
        _ubi.setId(userBankId);
        _ubi.setIsDefault(1);
        userBankInfoService.update(_ubi);

        // 更新账户金额
        BigDecimal totalMoney = DataMath.sub(accountIntegral.getTotalMoney().doubleValue(), amount.doubleValue());
        accountIntegral.setTotalMoney(totalMoney);
        accountIntegral.setUpdateUser(user.getId());
        accountIntegral.setUpdateTime(nowTime.getTime());
        userAccountIntegralService.update(accountIntegral);

        // 插入账变日志
        UserAccountIntegralChangeLog userAccountIntegralChangeLog = new UserAccountIntegralChangeLog();
        userAccountIntegralChangeLog.setTableName(Constant.FinalTableName.WITHDRAWAL);
        userAccountIntegralChangeLog
                .setType(Integer.valueOf(AccountIntegralChangeLogTypeEnum.WITHDRAWAL_APPLY.getCode()));
        userAccountIntegralChangeLog.setBusinessTableId(order.getId());
        userAccountIntegralChangeLog.setMoney(DataMath.negative(amount));
        userAccountIntegralChangeLog.setTotalMoney(totalMoney);
        userAccountIntegralChangeLog.setUserId(order.getUserId());
        userAccountIntegralChangeLog.setRemark(order.getRemark());
        userAccountIntegralChangeLog.setOrderNo(order.getOrderNo());
        userAccountIntegralChangeLog.setIpAddress(order.getIpAddress());

        userAccountIntegralChangeLogService.save(userAccountIntegralChangeLog);

        /** 添加风控消息提醒 */
        Map<String, Object> condition = new HashMap<String, Object>();
        condition.put("code", Constant.FinalFunctionCode.WITHDRAWAL_CODE);
        Function function = functionService.selectOne(condition);
        if (function != null) {
            // 查询部门消息
            List<Integer> typeList = Arrays.asList(Integer.valueOf(UserTypeAllEnum.FK.getCode()),
                    Integer.valueOf(UserTypeAllEnum.KF.getCode()));
            List<User> userList = userService.getUserListByUserType(typeList);

            Map<String, Object> param = new HashMap<String, Object>();
            param.put("userName", user.getLoginName());
            param.put("createTime", DateFormatUtils.format(Calendar.getInstance(), "yyyy-MM-dd HH:mm:ss"));
            param.put("money", order.getTradeAmount());
            param.put("url", ContextUrlManager.getBasePath() + function.getUrl());
            param.put("orderNo", order.getOrderNo());
            noticeService.saveSendNotice(param, userList, NoticeCodeEnum.WITHDRAWAL_FK_APPROVE.getCode());
        }

        return this.selectById(order.getId());

    }

    @Override
    public Class<WithdrawalOrder> getClazz() {
        return WithdrawalOrder.class;
    }

    @Override
    public BaseDaoImpl<WithdrawalOrder> baseDao() {
        return withdrawalOrderDao;
    }
}
