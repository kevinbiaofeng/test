package com.xjw.service.order.impl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.common.util.Constant;
import com.xjw.dao.order.DepositOrderDao;
import com.xjw.entity.form.order.DepositOrderForm;
import com.xjw.entity.form.pay.GuoFuBaoRespForm;
import com.xjw.entity.form.pay.LeYingForm;
import com.xjw.entity.form.pay.ShbScanCallbackForm;
import com.xjw.entity.form.pay.TongHuiWechatForm;
import com.xjw.entity.form.pay.YinBaoForm;
import com.xjw.entity.po.log.UserAccountIntegralChangeLog;
import com.xjw.entity.po.order.DepositOrder;
import com.xjw.entity.po.sys.FinalResourcesValues;
import com.xjw.entity.po.sys.Function;
import com.xjw.entity.po.sys.UserBankInfo;
import com.xjw.entity.po.user.AccountIntegral;
import com.xjw.entity.po.user.Member;
import com.xjw.entity.po.user.User;
import com.xjw.entity.vo.order.YSResponseVo;
import com.xjw.kzenum.AbstractEnum.EnumBean;
import com.xjw.kzenum.log.AccountIntegralChangeLogTypeEnum;
import com.xjw.kzenum.notice.NoticeCodeEnum;
import com.xjw.kzenum.order.OperationTypeEnum;
import com.xjw.kzenum.order.OrderStatusEnum;
import com.xjw.kzenum.order.TradeModeEnum;
import com.xjw.kzenum.pay.GuoFuBaoRespCode;
import com.xjw.kzenum.user.UserTypeAllEnum;
import com.xjw.service.log.UserAccountIntegralChangeLogService;
import com.xjw.service.notice.NoticeService;
import com.xjw.service.order.DepositOrderService;
import com.xjw.service.sys.FinalResourcesIndexService;
import com.xjw.service.sys.FunctionService;
import com.xjw.service.sys.UserBankInfoService;
import com.xjw.service.user.MemberService;
import com.xjw.service.user.UserAccountIntegralService;
import com.xjw.service.user.UserService;
import com.xjw.util.SequenceBuilder;
import com.xjw.util.SequenceBuilder.SequenceType;
import com.xjw.utility.ContextPropsLoad;
import com.xjw.utility.ContextUrlManager;
import com.xjw.utility.DataMath;
import com.xjw.utility.EncryptUtil;

@Service
public class DepositOrderServiceImpl extends BaseServiceImpl<DepositOrder> implements DepositOrderService {
    private static Logger logger = LoggerFactory.getLogger(DepositOrderServiceImpl.class);
    @Resource
    private DepositOrderDao depositOrderDao;
    @Resource
    private UserBankInfoService userBankInfoService;
    @Autowired
    private UserService userService;
    @Resource
    private MemberService memberService;
    @Autowired
    private FunctionService functionService;
    @Autowired
    private NoticeService noticeService;
    @Autowired
    private UserAccountIntegralService userAccountIntegralService;
    @Autowired
    private UserAccountIntegralChangeLogService userAccountIntegralChangeLogService;
    @Resource
    private FinalResourcesIndexService finalResourcesIndexService;

    public BigDecimal selectSumAmount(Map<String, Object> params) {
        return depositOrderDao.selectSumAmount(params);
    }

    public DepositOrder createOrder(Long userId, DepositOrderForm depositOrderForm) throws Exception {
        return this.createTransferBankOrder(depositOrderForm, userId, depositOrderForm.getTradeMode().toString());
    }

    /**
     * 网银转账
     */
    public DepositOrder createTransferBankOrder(DepositOrderForm depositOrderForm, Long userId, String tradeMode)
            throws Exception {
        Date dateTime = new Date();

        DepositOrder depositOrder = new DepositOrder();
        if (tradeMode.equals(TradeModeEnum.ONLINE_BANKING_PAYMENT.getCode())) {
            UserBankInfo userBankInfo = userBankInfoService.getBankInfoByBankType(depositOrderForm.getBankType());
            depositOrder.setToBankId(userBankInfo.getId());
            depositOrder.setToBankAccount(userBankInfo.getAccountName());
            depositOrder.setToBankCard(userBankInfo.getBankCardNo());
            depositOrder.setToBankType(String.valueOf(depositOrderForm.getBankType()));
        }

        depositOrder.setTradeMode(Integer.valueOf(tradeMode));
        depositOrder.setCreateTime(new Date());
        depositOrder.setOrderNo(SequenceBuilder.next(SequenceType.DP));
        depositOrder.setStatus(Integer.valueOf(OrderStatusEnum.DRAFT.getCode()));
        // 设置VO对象至存款信息
        depositOrder.setUserId(userId);
        depositOrder.setTradeAmount(depositOrderForm.getAmount());
        depositOrder.setIpAddress(depositOrderForm.getIp());
        depositOrder.setCreateTime(dateTime);

        Map<String, Object> condition = new HashMap<String, Object>();
        condition.put("code", Constant.FinalFunctionCode.DEPOSIT_CODE);
        Function function = functionService.selectOne(condition);
        if (function != null) {
            User user = userService.selectById(userId);
            // 查询部门消息
            List<User> userList = userService.getUserListByUserType(UserTypeAllEnum.CW.getCode());
            FinalResourcesValues finalResourcesValues = null;
            if (tradeMode.equals(TradeModeEnum.ONLINE_BANKING_PAYMENT.getCode())) // 只有银行转账需要保存银行名称
                finalResourcesIndexService.getByCodeAndVal(Constant.FinalResourceCodeManage.BANK_TYPE,
                        depositOrder.getToBankType());

            // 添加消息提醒
            Map<String, Object> param = new HashMap<String, Object>();
            param.put("userName", user.getLoginName());
            param.put("createTime", DateFormatUtils.format(dateTime, "yyyy-MM-dd HH:mm:ss"));
            param.put("money", depositOrder.getTradeAmount());
            param.put("url", ContextUrlManager.getBasePath() + function.getUrl());
            param.put("orderNo", depositOrder.getOrderNo());
            param.put("bankAccount", depositOrder.getToBankAccount());
            param.put("bankTypeName", finalResourcesValues != null ? finalResourcesValues.getName() : "");
            String noticeCode = NoticeCodeEnum.DEPOSIT_ONLINE_BANKING_PAYMENT.getCode();
            noticeService.saveSendNotice(param, userList, noticeCode);
        }

        // 设置存款用户账户名信息
        Member member = memberService.getMemberByUserId(userId);
        depositOrder.setFromBankAccount(EncryptUtil.decode(Constant.DateEncryptManage.NAME_PWD, member.getName()));
        return this.save(depositOrder);
    }

    public void callbackByGuoFuBao(GuoFuBaoRespForm form) throws Exception {
        logger.info("国付宝返回支付信息：[{}]", form.toString());

        // 签名和参数的校验
        if (!form.toSign().equals(form.getSignValue())) {
            logger.info("国付宝返回支付信息异常：签名不正确[{}][{}]", new Object[] { form.toSign(), form.getSignValue() });
            return;
        }

        DepositOrder depositOrder = depositOrderDao.queryByOrderNo(form.getMerOrderNum());

        // 支付订单状态校验
        if (!OrderStatusEnum.DRAFT.getCode().equals(String.valueOf(depositOrder.getStatus()))) {
            logger.info("国付宝返回支付信息异常：订单不是未到账状态。订单[{}]状态[[]]", new Object[] { depositOrder.getOrderNo(),
                    OrderStatusEnum.getNameByCode(OrderStatusEnum.class, depositOrder.getStatus().toString()) });
            return;
        }

        Calendar nowTime = Calendar.getInstance();
        EnumBean respCode = GuoFuBaoRespCode.getEnumByCode(GuoFuBaoRespCode.class, form.getRespCode());
        if (null == respCode) { // 未知状态
            logger.info("国付宝返回支付状态未知，订单编号[{}]状态码[{}]", new Object[] { form.getMerOrderNum(), form.getRespCode() });

            // 修改支付订单状态
            DepositOrder _order = new DepositOrder();
            _order.setOrderNo(form.getMerOrderNum());
            _order.setUpdateTime(nowTime.getTime());
            _order.setOperationType(Integer.valueOf(OperationTypeEnum.AUTOMATIC.getCode()));
            _order.setStatus(Integer.valueOf(OrderStatusEnum.FAIL.getCode()));
            _order.setRemark("国付宝返回支付状态未知，状态[" + form.getRespCode() + "]");
            this.update(_order);
        } else if (GuoFuBaoRespCode._0000.getCode().equals(respCode.getCode())) { // 成功状态
            logger.info("国付宝返回支付状态成功，订单编号[{}]", new Object[] { form.getMerOrderNum() });

            // 修改支付订单状态
            DepositOrder _order = new DepositOrder();
            _order.setOrderNo(form.getMerOrderNum());
            _order.setUpdateTime(nowTime.getTime());
            _order.setOperationType(Integer.valueOf(OperationTypeEnum.AUTOMATIC.getCode()));
            _order.setStatus(Integer.valueOf(OrderStatusEnum.SUCCESS.getCode()));
            _order.setRemark("国付宝返回支付状态成功");
            this.update(_order);

            // 重新读取最新数据
            depositOrder = depositOrderDao.queryByOrderNo(form.getMerOrderNum());
            // 支付金额
            BigDecimal payMoney = depositOrder.getTradeAmount();

            // 修改总账户余额
            AccountIntegral accountIntegral = userAccountIntegralService.selectByUserId(depositOrder.getUserId());
            BigDecimal totalMoney = DataMath.add(accountIntegral.getTotalMoney().doubleValue(), payMoney.doubleValue());
            accountIntegral.setTotalMoney(totalMoney);
            userAccountIntegralService.update(accountIntegral);

            // 插入账变日志
            UserAccountIntegralChangeLog userAccountIntegralChangeLog = new UserAccountIntegralChangeLog();
            userAccountIntegralChangeLog.setTableName(Constant.FinalTableName.DEPOSIT);
            userAccountIntegralChangeLog.setBusinessTableId(depositOrder.getId());
            userAccountIntegralChangeLog.setType(Integer.valueOf(AccountIntegralChangeLogTypeEnum.DEPOSIT.getCode()));
            userAccountIntegralChangeLog.setMoney(payMoney);
            userAccountIntegralChangeLog.setTotalMoney(totalMoney);
            userAccountIntegralChangeLog.setUserId(depositOrder.getUserId());
            userAccountIntegralChangeLog.setRemark(depositOrder.getRemark());
            userAccountIntegralChangeLog.setOrderNo(depositOrder.getOrderNo());
            userAccountIntegralChangeLog.setIpAddress(depositOrder.getIpAddress());
            userAccountIntegralChangeLogService.save(userAccountIntegralChangeLog);
        } else if (GuoFuBaoRespCode._9999.getCode().equals(form.getRespCode())) {
            logger.info("国付宝返回支付状态处理中，订单编号[{}]状态码:[{}]状态描述[{}]",
                    new Object[] { form.getMerOrderNum(), respCode.getCode(), respCode.getName() });
        } else { // 失败状态
            logger.info("国付宝返回支付状态失败，订单编号[{}]状态码:[{}]状态描述[{}]",
                    new Object[] { form.getMerOrderNum(), respCode.getCode(), respCode.getName() });

            // 修改支付订单状态
            DepositOrder _order = new DepositOrder();
            _order.setOrderNo(form.getMerOrderNum());
            _order.setUpdateTime(nowTime.getTime());
            _order.setOperationType(Integer.valueOf(OperationTypeEnum.AUTOMATIC.getCode()));
            _order.setStatus(Integer.valueOf(OrderStatusEnum.FAIL.getCode()));
            _order.setRemark("国付宝返回支付失败：状态[" + respCode.getCode() + "]描述[" + respCode.getName() + "]");
            this.update(_order);
        }
    }

    public void callbackByTongHui(TongHuiWechatForm form) throws Exception {
        logger.info("通汇微信返回支付信息：[{}]", form.toString());

        // 签名和参数的校验
        if (!form.toSign().equals(form.getSign())) {
            logger.info("通汇微信返回支付信息异常：签名不正确[{}][{}]", new Object[] { form.toSign(), form.getSign() });
            return;
        }

        DepositOrder depositOrder = depositOrderDao.queryByOrderNo(form.getOrder_no());

        // 支付订单状态校验
        if (!OrderStatusEnum.DRAFT.getCode().equals(String.valueOf(depositOrder.getStatus()))) {
            logger.info("通汇微信返回支付信息异常：订单不是未到账状态。订单[{}]状态[[]]", new Object[] { depositOrder.getOrderNo(),
                    OrderStatusEnum.getNameByCode(OrderStatusEnum.class, depositOrder.getStatus().toString()) });
            return;
        }

        String tradeStatus = form.getTrade_status();
        if (StringUtils.isNotEmpty(tradeStatus) && tradeStatus.equals("failed")) { // 失败状态
            logger.info("通汇微信返回支付状态失败，订单编号[{}]状态码[{}]", new Object[] { form.getOrder_no(), tradeStatus });

            // 修改支付订单状态
            DepositOrder _order = new DepositOrder();
            _order.setOrderNo(form.getOrder_no());
            _order.setUpdateTime(new Date());
            _order.setOperationType(Integer.valueOf(OperationTypeEnum.AUTOMATIC.getCode()));
            _order.setStatus(Integer.valueOf(OrderStatusEnum.FAIL.getCode()));
            _order.setRemark("通汇微信返回支付状态未知，状态[" + form.getTrade_status() + "]");
            this.update(_order);
        } else if (StringUtils.isNotEmpty(tradeStatus) && tradeStatus.equals("success")) { // 成功状态
            logger.info("通汇微信返回支付状态成功，订单编号[{}]", new Object[] { form.getOrder_no() });

            // 修改支付订单状态
            DepositOrder _order = new DepositOrder();
            _order.setOrderNo(form.getOrder_no());
            _order.setUpdateTime(new Date());
            _order.setOperationType(Integer.valueOf(OperationTypeEnum.AUTOMATIC.getCode()));
            _order.setStatus(Integer.valueOf(OrderStatusEnum.SUCCESS.getCode()));
            _order.setRemark("通汇微信返回支付状态成功");
            this.update(_order);

            // 重新读取最新数据
            depositOrder = depositOrderDao.queryByOrderNo(form.getOrder_no());
            // 支付金额
            BigDecimal payMoney = depositOrder.getTradeAmount()
                    .add(depositOrder.getTradeAmount().multiply(new BigDecimal(0.01)));

            // 修改总账户余额
            AccountIntegral accountIntegral = userAccountIntegralService.selectByUserId(depositOrder.getUserId());
            BigDecimal totalMoney = accountIntegral.getTotalMoney().add(payMoney);
            accountIntegral.setTotalMoney(totalMoney);
            userAccountIntegralService.update(accountIntegral);

            // 插入账变日志
            UserAccountIntegralChangeLog userAccountIntegralChangeLog = new UserAccountIntegralChangeLog();
            userAccountIntegralChangeLog.setTableName(Constant.FinalTableName.DEPOSIT);
            userAccountIntegralChangeLog.setBusinessTableId(depositOrder.getId());
            userAccountIntegralChangeLog.setType(Integer.valueOf(AccountIntegralChangeLogTypeEnum.DEPOSIT.getCode()));
            userAccountIntegralChangeLog.setMoney(payMoney);
            userAccountIntegralChangeLog.setTotalMoney(totalMoney);
            userAccountIntegralChangeLog.setUserId(depositOrder.getUserId());
            userAccountIntegralChangeLog.setRemark(depositOrder.getRemark());
            userAccountIntegralChangeLog.setOrderNo(depositOrder.getOrderNo());
            userAccountIntegralChangeLog.setIpAddress(depositOrder.getIpAddress());
            userAccountIntegralChangeLogService.save(userAccountIntegralChangeLog);

        } else if (StringUtils.isNotEmpty(tradeStatus) && tradeStatus.equals("paying")) { // 交易进行中，不做处理
            logger.info("通汇微信返回支付状态处理中，订单编号[{}]状态码:[{}]状态描述[{}]", new Object[] { form.getOrder_no(), tradeStatus });
        } else { // 未知状态
            logger.info("通汇微信返回支付状态失败，订单编号[{}]状态码:[{}]状态描述[{}]", new Object[] { form.getOrder_no(), tradeStatus });

            // 修改支付订单状态
            DepositOrder _order = new DepositOrder();
            _order.setOrderNo(form.getOrder_no());
            _order.setUpdateTime(new Date());
            _order.setOperationType(Integer.valueOf(OperationTypeEnum.AUTOMATIC.getCode()));
            _order.setStatus(Integer.valueOf(OrderStatusEnum.FAIL.getCode()));
            _order.setRemark("通汇微信返回支付失败：状态[" + tradeStatus + "]描述[" + form.getOrder_no() + "]");
            this.update(_order);
        }
    }

    /**
     * 银宝回调
     */
    public void callbackByYinBao(YinBaoForm form) throws Exception {
        logger.info("银宝返回支付信息：[{}]", form.toString());

        // 签名和参数的校验
        if (!form.md5().equals(form.getSign())) {
            logger.info("银宝返回支付信息异常：签名不正确[{}][{}]", new Object[] { form.md5(), form.getSign() });
            return;
        }

        DepositOrder depositOrder = depositOrderDao.queryByOrderNo(form.getOrdernumber());

        // 支付订单状态校验
        if (!OrderStatusEnum.DRAFT.getCode().equals(String.valueOf(depositOrder.getStatus()))) {
            logger.info("银宝返回支付信息异常：订单不是未到账状态。订单[{}]状态[[]]", new Object[] { depositOrder.getOrderNo(),
                    OrderStatusEnum.getNameByCode(OrderStatusEnum.class, depositOrder.getStatus().toString()) });
            return;
        }

        if (StringUtils.equals("1", form.getOrderstatus())) {
            logger.info("银宝返回支付状态成功，订单[{}]", new Object[] { form.getOrdernumber() });

            // 修改支付订单状态
            DepositOrder _order = new DepositOrder();
            _order.setOrderNo(form.getOrdernumber());
            _order.setUpdateTime(new Date());
            _order.setOperationType(Integer.valueOf(OperationTypeEnum.AUTOMATIC.getCode()));
            _order.setStatus(Integer.valueOf(OrderStatusEnum.SUCCESS.getCode()));
            _order.setRemark("银宝返回支付状态成功");
            this.update(_order);

            // 重新读取最新数据
            depositOrder = depositOrderDao.queryByOrderNo(form.getOrdernumber());
            // 支付金额
            BigDecimal payMoney = depositOrder.getTradeAmount()
                    .add(depositOrder.getTradeAmount().multiply(new BigDecimal(0.01)));

            // 修改总账户余额
            AccountIntegral accountIntegral = userAccountIntegralService.selectByUserId(depositOrder.getUserId());
            BigDecimal totalMoney = accountIntegral.getTotalMoney().add(payMoney);
            accountIntegral.setTotalMoney(totalMoney);
            userAccountIntegralService.update(accountIntegral);

            // 插入账变日志
            UserAccountIntegralChangeLog userAccountIntegralChangeLog = new UserAccountIntegralChangeLog();
            userAccountIntegralChangeLog.setTableName(Constant.FinalTableName.DEPOSIT);
            userAccountIntegralChangeLog.setBusinessTableId(depositOrder.getId());
            userAccountIntegralChangeLog.setType(Integer.valueOf(AccountIntegralChangeLogTypeEnum.DEPOSIT.getCode()));
            userAccountIntegralChangeLog.setMoney(payMoney);
            userAccountIntegralChangeLog.setTotalMoney(totalMoney);
            userAccountIntegralChangeLog.setUserId(depositOrder.getUserId());
            userAccountIntegralChangeLog.setRemark(depositOrder.getRemark());
            userAccountIntegralChangeLog.setOrderNo(depositOrder.getOrderNo());
            userAccountIntegralChangeLog.setIpAddress(depositOrder.getIpAddress());
            userAccountIntegralChangeLogService.save(userAccountIntegralChangeLog);
        } else {
            logger.info("银宝返回支付状态失败，订单[{}]状态[{}]", new Object[] { form.getOrdernumber(), form.getOrderstatus() });
            // 修改支付订单状态
            DepositOrder _order = new DepositOrder();
            _order.setOrderNo(form.getOrdernumber());
            _order.setUpdateTime(new Date());
            _order.setOperationType(Integer.valueOf(OperationTypeEnum.AUTOMATIC.getCode()));
            _order.setStatus(Integer.valueOf(OrderStatusEnum.FAIL.getCode()));
            _order.setRemark("银宝返回支付失败：银宝订单[" + form.getSysnumber() + "]状态[" + form.getOrderstatus() + "]");
            this.update(_order);
        }
    }

    /**
     * 乐盈回调
     */
    private static final String pkey = ContextPropsLoad.getValByKey("PARTNER.PUBKEY");

    public void callbackByLeYing(LeYingForm form) throws Exception {
        logger.info("乐盈返回支付信息：[{}]", form.toString());

        // 签名和参数的校验
        if (!form.md5(pkey).equals(form.getSignMsg())) {
            logger.info("乐盈返回支付信息异常：签名不正确[{}][{}]", new Object[] { form.md5(pkey), form.getSignMsg() });
            return;
        }

        DepositOrder depositOrder = depositOrderDao.queryByOrderNo(form.getOrderID());

        // 支付订单状态校验
        if (!OrderStatusEnum.DRAFT.getCode().equals(String.valueOf(depositOrder.getStatus()))) {
            logger.info("乐盈返回支付信息异常：订单不是未到账状态。订单[{}]状态[[]]", new Object[] { depositOrder.getOrderNo(),
                    OrderStatusEnum.getNameByCode(OrderStatusEnum.class, depositOrder.getStatus().toString()) });
            return;
        }

        // stateCode : 2 处理成功
        if (StringUtils.equals("2", form.getStateCode())) {
            logger.info("乐盈返回支付状态成功，订单[{}]", new Object[] { form.getOrderID() });

            // 修改支付订单状态
            DepositOrder _order = new DepositOrder();
            _order.setOrderNo(form.getOrderID());
            _order.setUpdateTime(new Date());
            _order.setOperationType(Integer.valueOf(OperationTypeEnum.AUTOMATIC.getCode()));
            _order.setStatus(Integer.valueOf(OrderStatusEnum.SUCCESS.getCode()));
            _order.setRemark("乐盈返回支付状态成功");
            this.update(_order);

            // 重新读取最新数据
            depositOrder = depositOrderDao.queryByOrderNo(form.getOrderID());
            // 支付金额
            BigDecimal payMoney = depositOrder.getTradeAmount()
                    .add(depositOrder.getTradeAmount().multiply(new BigDecimal(0.01)));

            // 修改总账户余额
            AccountIntegral accountIntegral = userAccountIntegralService.selectByUserId(depositOrder.getUserId());
            BigDecimal totalMoney = accountIntegral.getTotalMoney().add(payMoney);
            accountIntegral.setTotalMoney(totalMoney);
            userAccountIntegralService.update(accountIntegral);

            // 插入账变日志
            UserAccountIntegralChangeLog userAccountIntegralChangeLog = new UserAccountIntegralChangeLog();
            userAccountIntegralChangeLog.setTableName(Constant.FinalTableName.DEPOSIT);
            userAccountIntegralChangeLog.setBusinessTableId(depositOrder.getId());
            userAccountIntegralChangeLog.setType(Integer.valueOf(AccountIntegralChangeLogTypeEnum.DEPOSIT.getCode()));
            userAccountIntegralChangeLog.setMoney(payMoney);
            userAccountIntegralChangeLog.setTotalMoney(totalMoney);
            userAccountIntegralChangeLog.setUserId(depositOrder.getUserId());
            userAccountIntegralChangeLog.setRemark(depositOrder.getRemark());
            userAccountIntegralChangeLog.setOrderNo(depositOrder.getOrderNo());
            userAccountIntegralChangeLog.setIpAddress(depositOrder.getIpAddress());
            userAccountIntegralChangeLogService.save(userAccountIntegralChangeLog);
        } else {
            logger.info("乐盈返回支付状态失败，订单[{}]状态[{}]", new Object[] { form.getOrderID(), form.getStateCode() });
            // 修改支付订单状态
            DepositOrder _order = new DepositOrder();
            _order.setOrderNo(form.getOrderID());
            _order.setUpdateTime(new Date());
            _order.setOperationType(Integer.valueOf(OperationTypeEnum.AUTOMATIC.getCode()));
            _order.setStatus(Integer.valueOf(OrderStatusEnum.FAIL.getCode()));
            _order.setRemark("乐盈返回支付失败：乐盈订单[" + form.getOrderNo() + "]状态[" + form.getStateCode() + "]");
            this.update(_order);
        }
    }

    /**
     * 速汇宝扫码回调
     */
    public void callbackByShbScan(ShbScanCallbackForm form) throws Exception {
        logger.info("速汇宝扫码返回支付信息：[{}]", JSONObject.toJSONString(form));

        // 签名和参数的校验
        // if(!form.md5().equals(form.getSign())){
        // logger.info("速汇宝扫码返回支付信息异常：签名不正确[{}][{}]", new Object[]{form.md5(),
        // form.getSign()});
        // return;
        // }

        DepositOrder depositOrder = depositOrderDao.queryByOrderNo(form.getOrder_no());

        // 支付订单状态校验
        if (!OrderStatusEnum.DRAFT.getCode().equals(String.valueOf(depositOrder.getStatus()))) {
            logger.info("速汇宝扫码返回支付信息异常：订单不是未到账状态。订单[{}]状态[[]]", new Object[] { depositOrder.getOrderNo(),
                    OrderStatusEnum.getNameByCode(OrderStatusEnum.class, depositOrder.getStatus().toString()) });
            return;
        }

        if (StringUtils.equals("SUCCESS", form.getTrade_status())) {
            logger.info("速汇宝扫码返回支付状态成功，订单[{}]", new Object[] { form.getOrder_no() });

            // 修改支付订单状态
            DepositOrder _order = new DepositOrder();
            _order.setOrderNo(form.getOrder_no());
            _order.setUpdateTime(new Date());
            _order.setOperationType(Integer.valueOf(OperationTypeEnum.AUTOMATIC.getCode()));
            _order.setStatus(Integer.valueOf(OrderStatusEnum.SUCCESS.getCode()));
            _order.setRemark("速汇宝扫码返回支付状态成功");
            this.update(_order);

            // 重新读取最新数据
            depositOrder = depositOrderDao.queryByOrderNo(form.getOrder_no());
            // 支付金额
            BigDecimal payMoney = depositOrder.getTradeAmount()
                    .add(depositOrder.getTradeAmount().multiply(new BigDecimal(0.01)));

            // 修改总账户余额
            AccountIntegral accountIntegral = userAccountIntegralService.selectByUserId(depositOrder.getUserId());
            BigDecimal totalMoney = accountIntegral.getTotalMoney().add(payMoney);
            accountIntegral.setTotalMoney(totalMoney);
            userAccountIntegralService.update(accountIntegral);

            // 插入账变日志
            UserAccountIntegralChangeLog userAccountIntegralChangeLog = new UserAccountIntegralChangeLog();
            userAccountIntegralChangeLog.setTableName(Constant.FinalTableName.DEPOSIT);
            userAccountIntegralChangeLog.setBusinessTableId(depositOrder.getId());
            userAccountIntegralChangeLog.setType(Integer.valueOf(AccountIntegralChangeLogTypeEnum.DEPOSIT.getCode()));
            userAccountIntegralChangeLog.setMoney(payMoney);
            userAccountIntegralChangeLog.setTotalMoney(totalMoney);
            userAccountIntegralChangeLog.setUserId(depositOrder.getUserId());
            userAccountIntegralChangeLog.setRemark(depositOrder.getRemark());
            userAccountIntegralChangeLog.setOrderNo(depositOrder.getOrderNo());
            userAccountIntegralChangeLog.setIpAddress(depositOrder.getIpAddress());
            userAccountIntegralChangeLogService.save(userAccountIntegralChangeLog);
        } else {
            logger.info("速汇宝扫码返回支付状态失败，订单[{}]状态[{}]", new Object[] { form.getOrder_no(), form.getTrade_status() });
            // 修改支付订单状态
            DepositOrder _order = new DepositOrder();
            _order.setOrderNo(form.getOrder_no());
            _order.setUpdateTime(new Date());
            _order.setOperationType(Integer.valueOf(OperationTypeEnum.AUTOMATIC.getCode()));
            _order.setStatus(Integer.valueOf(OrderStatusEnum.FAIL.getCode()));
            _order.setRemark("速汇宝扫码返回支付失败：速汇宝订单[" + form.getTrade_no() + "]状态[" + form.getTrade_status() + "]");
            this.update(_order);
        }
    }

    public void callbackByYS(YSResponseVo vo) throws Exception {
        logger.info("云盛返回数据：[{}]", JSONObject.toJSONString(vo));

        // 签名和参数的校验
        if (!vo.checkSign()) {
            logger.info("云盛返回数据异常：签名不正确[{}]", new Object[] { vo.getSign() });
            return;
        }

        DepositOrder depositOrder = depositOrderDao.queryByOrderNo(vo.getBillno());

        // 支付订单状态校验
        if (!OrderStatusEnum.DRAFT.getCode().equals(String.valueOf(depositOrder.getStatus()))) {
            logger.info("云盛返回支付信息异常：订单不是未到账状态。订单[{}]状态[[]]", new Object[] { depositOrder.getOrderNo(),
                    OrderStatusEnum.getNameByCode(OrderStatusEnum.class, depositOrder.getStatus().toString()) });
            return;
        }

        Calendar nowTime = Calendar.getInstance();
        if ("Success".equals(vo.getSuccess())) { // 成功
            logger.info("云盛返回支付状态成功，订单编号[{}]", new Object[] { vo.getBillno() });

            // 修改支付订单状态
            DepositOrder _order = new DepositOrder();
            _order.setOrderNo(vo.getBillno());
            _order.setUpdateTime(nowTime.getTime());
            _order.setOperationType(Integer.valueOf(OperationTypeEnum.AUTOMATIC.getCode()));
            _order.setStatus(Integer.valueOf(OrderStatusEnum.SUCCESS.getCode()));
            _order.setRemark("云盛返回支付状态成功");
            this.update(_order);

            // 重新读取最新数据
            depositOrder = depositOrderDao.queryByOrderNo(vo.getBillno());
            // 支付金额
            BigDecimal payMoney = depositOrder.getTradeAmount();

            // 修改总账户余额
            AccountIntegral accountIntegral = userAccountIntegralService.selectByUserId(depositOrder.getUserId());
            BigDecimal totalMoney = DataMath.add(accountIntegral.getTotalMoney().doubleValue(), payMoney.doubleValue());
            accountIntegral.setTotalMoney(totalMoney);
            userAccountIntegralService.update(accountIntegral);

            // 插入账变日志
            UserAccountIntegralChangeLog userAccountIntegralChangeLog = new UserAccountIntegralChangeLog();
            userAccountIntegralChangeLog.setTableName(Constant.FinalTableName.DEPOSIT);
            userAccountIntegralChangeLog.setBusinessTableId(depositOrder.getId());
            userAccountIntegralChangeLog.setType(Integer.valueOf(AccountIntegralChangeLogTypeEnum.DEPOSIT.getCode()));
            userAccountIntegralChangeLog.setMoney(payMoney);
            userAccountIntegralChangeLog.setTotalMoney(totalMoney);
            userAccountIntegralChangeLog.setUserId(depositOrder.getUserId());
            userAccountIntegralChangeLog.setRemark(depositOrder.getRemark());
            userAccountIntegralChangeLog.setOrderNo(depositOrder.getOrderNo());
            userAccountIntegralChangeLog.setIpAddress(depositOrder.getIpAddress());
            userAccountIntegralChangeLogService.save(userAccountIntegralChangeLog);
        } else if ("Failure".equals(vo.getSuccess())) { // 失败
            logger.info("云盛返回支付状态失败，订单编号[{}]状态码:[{}]", new Object[] { vo.getBillno(), vo.getSuccess() });

            // 修改支付订单状态
            DepositOrder _order = new DepositOrder();
            _order.setOrderNo(vo.getBillno());
            _order.setUpdateTime(nowTime.getTime());
            _order.setOperationType(Integer.valueOf(OperationTypeEnum.AUTOMATIC.getCode()));
            _order.setStatus(Integer.valueOf(OrderStatusEnum.FAIL.getCode()));
            _order.setRemark("云盛返回支付失败：状态[" + vo.getSuccess() + "]");
            this.update(_order);
        } else { // 未知状态
            logger.info("云盛返回支付状态未知，订单编号[{}]状态码[{}]", new Object[] { vo.getBillno(), vo.getSuccess() });

            // 修改支付订单状态
            DepositOrder _order = new DepositOrder();
            _order.setOrderNo(vo.getBillno());
            _order.setUpdateTime(nowTime.getTime());
            _order.setOperationType(Integer.valueOf(OperationTypeEnum.AUTOMATIC.getCode()));
            _order.setStatus(Integer.valueOf(OrderStatusEnum.FAIL.getCode()));
            _order.setRemark("云盛返回支付状态未知，状态[" + vo.getSuccess() + "]");
            this.update(_order);
        }
    }

    @Override
    public Class<DepositOrder> getClazz() {
        return DepositOrder.class;
    }

    @Override
    public BaseDaoImpl<DepositOrder> baseDao() {
        return depositOrderDao;
    }
}
