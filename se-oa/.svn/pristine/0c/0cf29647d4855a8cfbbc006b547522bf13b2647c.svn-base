package com.xjw.service.order.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.common.util.Constant;
import com.xjw.dao.order.DepositOrderDao;
import com.xjw.entity.form.order.DepositOrderForm;
import com.xjw.entity.po.activity.UserBankInfo;
import com.xjw.entity.po.log.UserAccountIntegralChangeLog;
import com.xjw.entity.po.order.DepositOrder;
import com.xjw.entity.po.sys.FinalResourcesValues;
import com.xjw.entity.po.sys.Function;
import com.xjw.entity.po.sys.User;
import com.xjw.entity.po.user.AccountIntegral;
import com.xjw.entity.vo.order.DepositOrderVo;
import com.xjw.kzenum.log.AccountIntegralChangeLogTypeEnum;
import com.xjw.kzenum.notice.NoticeCodeEnum;
import com.xjw.kzenum.order.OperationTypeEnum;
import com.xjw.kzenum.order.OrderStatusEnum;
import com.xjw.kzenum.order.TradeModeEnum;
import com.xjw.kzenum.platform.PlatformTypeEnum;
import com.xjw.kzenum.sys.UserTypeAllEnum;
import com.xjw.service.activity.UserBankInfoService;
import com.xjw.service.log.UserAccountIntegralChangeLogService;
import com.xjw.service.notice.NoticeService;
import com.xjw.service.order.DepositOrderService;
import com.xjw.service.pay.LefuService;
import com.xjw.service.sys.FinalResourcesIndexService;
import com.xjw.service.sys.FunctionService;
import com.xjw.service.sys.UserService;
import com.xjw.service.user.MemberRemarkService;
import com.xjw.service.user.UserAccountChangeService;
import com.xjw.util.SequenceBuilder;
import com.xjw.util.SequenceBuilder.SequenceType;
import com.xjw.utility.BizException;
import com.xjw.utility.ContextUrlManager;
import com.xjw.utility.DataMath;
import com.xjw.utility.StringUtil;

@Service
public class DepositOrderServiceImpl extends BaseServiceImpl<DepositOrder> implements DepositOrderService {
	private static Logger logger = LoggerFactory.getLogger(DepositOrderServiceImpl.class.getName());
	@Resource
	private DepositOrderDao depositOrderDao;
	@Resource
	private UserBankInfoService userBankInfoService;
	@Resource
	private UserService userService;
	@Resource
	private UserAccountChangeService userAccountChangeService;
	@Resource
	private UserAccountIntegralChangeLogService userAccountIntegralChangeLogService;
	@Resource
	private NoticeService noticeService;
	@Resource
	private FunctionService functionService;
	@Resource
	private FinalResourcesIndexService finalResourcesIndexService;
	@Resource
	private LefuService lefuService;

	@Resource
	private MemberRemarkService memberRemarkService;

	public DepositOrder createBankTransferAccounts(DepositOrderVo vo) throws BizException {
		DepositOrder depositOrder = new DepositOrder();
		UserBankInfo userBankInfo = userBankInfoService.findUserBankInfoByBankType(vo.getBankType());
		depositOrder.setToBankId(userBankInfo.getId());
		depositOrder.setToBankAccount(userBankInfo.getAccountName());
		depositOrder.setToBankCard(userBankInfo.getBankCardNo());
		depositOrder.setToBankType(String.valueOf(vo.getBankType()));
		depositOrder.setTradeMode(Integer.valueOf(TradeModeEnum.ONLINE_BANKING_PAYMENT.getCode()));
		depositOrder.setOrderNo(SequenceBuilder.next(SequenceType.DP));
		depositOrder.setStatus(Integer.valueOf(OrderStatusEnum.DRAFT.getCode()));

		this.setVoParams(depositOrder, vo);// 设置VO参数
		return this.save(depositOrder);
	}

	public DepositOrder createThirdPartyAccounts(DepositOrderVo vo) throws BizException {
		DepositOrder depositOrder = new DepositOrder();
		depositOrder.setTradeMode(Integer.valueOf(TradeModeEnum.ONLINE_PAYMENT.getCode()));
		depositOrder.setOrderNo(SequenceBuilder.next(SequenceType.DP));
		depositOrder.setStatus(Integer.valueOf(OrderStatusEnum.DRAFT.getCode()));
		this.setVoParams(depositOrder, vo);// 设置VO参数
		return this.save(depositOrder);
	}

	public void thirdPartyResponse(String orderNo) throws BizException {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("orderNo", orderNo);
		DepositOrder depositOrder = this.selectOne(condition);

		if (OrderStatusEnum.DRAFT.getCode().equals(String.valueOf(depositOrder.getStatus()))) { // 避免重复提交
			DepositOrderForm depositOrderForm = new DepositOrderForm();
			String resultStr = null;
			try {
				resultStr = lefuService.updatelefuSearchRest(orderNo);
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(e.getMessage(), e);
				logger.error("---fill---:" + e.fillInStackTrace());
				logger.error("---msg---:" + e.getMessage());
				logger.error("---e---:" + e.toString());
			}
			if (resultStr.equals("00")) {
				depositOrderForm.setOperationType(OperationTypeEnum.AUTOMATIC.getCode());
				depositOrderForm.setStatus("success");
				depositOrderForm.setId(depositOrder.getId().toString());
				depositOrderForm.setRemark(depositOrder.getRemark());
				this.updateOrderExamine(depositOrderForm);
			}
		}
	}

	/**
	 * 生成订单时调用，设置VO参数
	 * 
	 * @param depositOrder
	 * @param vo
	 * @return
	 */
	private DepositOrder setVoParams(DepositOrder depositOrder, DepositOrderVo vo) throws BizException {
		Date dateTime = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 设置VO对象至存款信息
		depositOrder.setUserId(vo.getUserId());
		depositOrder.setTradeAmount(vo.getAmount());
		depositOrder.setPreferentialCode(vo.getPreferentialCode());
		depositOrder.setIpAddress(vo.getIpAddress());
		depositOrder.setCreateTime(dateTime);

		// 设置存款用户账户名信息
		User user = userService.selectById(vo.getUserId());
		depositOrder.setFromBankAccount(user.getUserName());

		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("code", Constant.FinalFunctionCode.DEPOSIT_CODE);
		Function function = functionService.selectOne(condition);

		// 查询部门消息
		List<User> userList = userService.getUserListByUserType(UserTypeAllEnum.CW.getCode());

		// 添加消息提醒
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("userName", user.getLoginName());
		param.put("createTime", format.format(dateTime));
		param.put("money", depositOrder.getTradeAmount());
		if (function != null) {
			param.put("url", ContextUrlManager.getBasePath() + function.getUrl());
			param.put("orderNo", depositOrder.getOrderNo());
			String noticeCode = null;
			if (TradeModeEnum.ONLINE_BANKING_PAYMENT.getCode().equals(String.valueOf(depositOrder.getTradeMode()))) {
				param.put("bankAccount", depositOrder.getToBankAccount());
				FinalResourcesValues finalResourcesValues = finalResourcesIndexService
						.getByCodeAndVal(Constant.FinalResourceCodeManage.BANK_TYPE, depositOrder.getToBankType());
				param.put("bankTypeName", finalResourcesValues.getName());
				noticeCode = NoticeCodeEnum.DEPOSIT_ONLINE_BANKING_PAYMENT.getCode();
			} else {
				noticeCode = NoticeCodeEnum.DEPOSIT_ONLINE_PAYMENT.getCode();
			}
			noticeService.saveSendNotice(param, userList, noticeCode);
		}

		return depositOrder;
	}

	public synchronized void updateOrderExamine(DepositOrderForm depositOrderForm) throws BizException {
		Map<String, Object> param = new HashMap<String, Object>();

		// 订单详细信息
		DepositOrder depositOrder = this.selectById(Long.valueOf(depositOrderForm.getId()));
		if (OrderStatusEnum.DRAFT.getCode().equals(String.valueOf(depositOrder.getStatus()))) { // 避免重复提交
			String success = depositOrderForm.getStatus();
			if (StringUtil.isNotBlank(success) && success.equals("success")) {
				param.put("status", OrderStatusEnum.SUCCESS.getCode());

				// 修改用户总账户
				BigDecimal money = depositOrder.getTradeAmount();

				Map<String, Object> conditionParam = new HashMap<String, Object>();
				conditionParam.put("userId", depositOrder.getUserId());
				AccountIntegral accountIntegral = userAccountChangeService.selectOne(conditionParam);

				// 变化后的总账户余额
				BigDecimal totalMoney = DataMath.add(accountIntegral.getTotalMoney().doubleValue(),
						money.doubleValue());
				accountIntegral.setTotalMoney(totalMoney);
				userAccountChangeService.update(accountIntegral);

				/** 插入账变日志 **/
				UserAccountIntegralChangeLog userAccountIntegralChangeLog = new UserAccountIntegralChangeLog();
				// 表名 表ID
				userAccountIntegralChangeLog.setTableName(Constant.FinalTableName.DEPOSIT);
				userAccountIntegralChangeLog.setBusinessTableId(depositOrder.getId());
				// 账变类型
				userAccountIntegralChangeLog
						.setType(Integer.valueOf(AccountIntegralChangeLogTypeEnum.DEPOSIT.getCode()));
				// 收入
				userAccountIntegralChangeLog.setMoney(money);
				userAccountIntegralChangeLog.setTotalMoney(totalMoney);
				userAccountIntegralChangeLog.setGameType(Integer.valueOf(PlatformTypeEnum.MAIN.getCode()));
				userAccountIntegralChangeLog.setUserId(depositOrder.getUserId());
				userAccountIntegralChangeLog.setRemark(depositOrder.getRemark());
				userAccountIntegralChangeLog.setOrderNo(depositOrder.getOrderNo());
				userAccountIntegralChangeLog.setIpAddress(depositOrder.getIpAddress());
				userAccountIntegralChangeLogService.save(userAccountIntegralChangeLog);
			} else {
				param.put("status", OrderStatusEnum.FAIL.getCode());
				//MemberRemark memberRemark = new MemberRemark();
				//memberRemark.setRemark(depositOrderForm.getRemark());
				//memberRemark.setTitleType(Integer.parseInt(RemarkTitleTypeEnum.CW.getCode()));
				//memberRemark.setUserId(depositOrder.getUserId());
				//memberRemark.setStatus(Integer.parseInt(StatusEnum.DEFAULT.getCode()));
				//memberRemarkService.save(memberRemark);
			}
			if (StringUtils.isNotBlank(depositOrderForm.getOperationType())) {
				param.put("operationType", depositOrderForm.getOperationType());
			} else {
				param.put("operationType", OperationTypeEnum.MANUAL.getCode());
			}
			param.put("remark", depositOrderForm.getRemark());
			param.put("id", depositOrderForm.getId());
			// 修改订单状态
			this.update(param);
		}
	}

	public synchronized void updateByAudit(Long id, Integer status, String remark) throws BizException {
		DepositOrder depositOrder = this.selectById(id);
		if (null == depositOrder || !OrderStatusEnum.DRAFT.getCode().equals(String.valueOf(depositOrder.getStatus()))) {
			return;
		}

		if (Integer.valueOf(OrderStatusEnum.FAIL.getCode()).equals(status)) {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("status", OrderStatusEnum.FAIL.getCode());
			params.put("operationType", OperationTypeEnum.MANUAL.getCode());
			params.put("id", id);
			params.put("remark", remark);
			this.update(params);
		} else if (Integer.valueOf(OrderStatusEnum.SUCCESS.getCode()).equals(status)) {
			// 更新状态
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("status", OrderStatusEnum.SUCCESS.getCode());
			params.put("operationType", OperationTypeEnum.MANUAL.getCode());
			params.put("id", id);
			params.put("remark", remark);
			this.update(params);

			// 修改用户总账户
			BigDecimal money = depositOrder.getTradeAmount();

			Map<String, Object> conditionParam = new HashMap<String, Object>();
			conditionParam.put("userId", depositOrder.getUserId());
			AccountIntegral accountIntegral = userAccountChangeService.selectOne(conditionParam);

			// 变化后的总账户余额
			BigDecimal totalMoney = DataMath.add(accountIntegral.getTotalMoney().doubleValue(), money.doubleValue());
			accountIntegral.setTotalMoney(totalMoney);
			userAccountChangeService.update(accountIntegral);

			/** 插入账变日志 **/
			UserAccountIntegralChangeLog userAccountIntegralChangeLog = new UserAccountIntegralChangeLog();
			userAccountIntegralChangeLog.setTableName(Constant.FinalTableName.DEPOSIT); // 表名
			userAccountIntegralChangeLog.setBusinessTableId(depositOrder.getId()); // 表ID
			userAccountIntegralChangeLog.setType(Integer.valueOf(AccountIntegralChangeLogTypeEnum.DEPOSIT.getCode())); // 账变类型
			userAccountIntegralChangeLog.setMoney(money); // 收入
			userAccountIntegralChangeLog.setTotalMoney(totalMoney);
			userAccountIntegralChangeLog.setUserId(depositOrder.getUserId());
			userAccountIntegralChangeLog.setRemark(depositOrder.getRemark());
			userAccountIntegralChangeLog.setOrderNo(depositOrder.getOrderNo());
			userAccountIntegralChangeLog.setIpAddress(depositOrder.getIpAddress());
			userAccountIntegralChangeLogService.save(userAccountIntegralChangeLog);
		}
	}
	
	public long selectAllCountByUser(Map<String, Object> params){
		return depositOrderDao.selectAllCountByUser(params);
	}
	
	@Override
	public Class<DepositOrder> getClazz() {
		return DepositOrder.class;
	}

	@Override
	public BaseDaoImpl<DepositOrder> baseDao() {
		return depositOrderDao;
	}
	
	public BigDecimal selectAmountByAgent(Map<String, Object> params) {
		return depositOrderDao.selectAmountByAgent(params);
	}

	public static void main(String[] args) {
		System.out.println(UUID.randomUUID().toString());
	}

	/**
	 * 存款订单定时拒绝业务处理逻辑
	 */
	public void updateDepositStatus() throws BizException {
		/*Map<String, Object> conditionParam = new HashMap<String, Object>();
		conditionParam.put("notInParentIds", AloneConstant.AGENT_USER_ID_LIST);
		conditionParam.put("statusList", StringUtil.getListFromStr("1"));
		List<DepositOrder> listDepositOrder = this.selectAll(conditionParam);		
		Map<String, Object> param = new HashMap<String, Object>();
		for (DepositOrder depositOrder : listDepositOrder) { // 订单详细信息
			Date createtime = depositOrder.getCreateTime();//单据创建时间
			String endtime = DateUtil.getHourofDay(new Date());//三个小时之前的时间
			Date start = DateUtil.formatStr(endtime, "yyyy-MM-dd HH:mm:ss");
			if(start.getTime() > createtime.getTime()){
				if (OrderStatusEnum.DRAFT.getCode().equals(String.valueOf(depositOrder.getStatus()))) {
					param.put("status", OrderStatusEnum.FAIL.getCode());//失败
					param.put("operationType", OperationTypeEnum.MANUAL.getCode());//手动
					param.put("remark", "未收到您的款项，系统自动回收您的提交订单.");
					param.put("id", depositOrder.getId());
					this.update(param);// 修改订单状态
				}
			}
			param.clear();
		}*/
		
		//存款订单拒绝功能, 会员存款5个小时转账未到系统账户的订单,修改状态
		depositOrderDao.updateStatus();
	}
	
}
