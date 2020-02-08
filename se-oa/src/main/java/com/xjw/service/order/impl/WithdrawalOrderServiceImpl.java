package com.xjw.service.order.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.common.util.Constant;
import com.xjw.dao.order.WithdrawalOrderDao;
import com.xjw.entity.form.order.WithdrawalOrderForm;
import com.xjw.entity.po.Email;
import com.xjw.entity.po.activity.UserBankInfo;
import com.xjw.entity.po.log.UserAccountIntegralChangeLog;
import com.xjw.entity.po.order.WithdrawalFinance;
import com.xjw.entity.po.order.WithdrawalOrder;
import com.xjw.entity.po.order.WithdrawalRisk;
import com.xjw.entity.po.order.WithdrawalTimeCount;
import com.xjw.entity.po.sys.Function;
import com.xjw.entity.po.sys.User;
import com.xjw.entity.po.user.AccountIntegral;
import com.xjw.entity.vo.order.DrawalCount;
import com.xjw.entity.vo.order.WithdrawalOrderVo;
import com.xjw.kzenum.activity.UserBankInfoTypeEnum;
import com.xjw.kzenum.log.AccountIntegralChangeLogTypeEnum;
import com.xjw.kzenum.notice.NoticeCodeEnum;
import com.xjw.kzenum.order.OrderStatusEnum;
import com.xjw.kzenum.platform.PlatformTypeEnum;
import com.xjw.kzenum.sys.UserTypeAllEnum;
import com.xjw.kzenum.sys.YesORNoEnum;
import com.xjw.service.activity.UserBankInfoService;
import com.xjw.service.log.UserAccountIntegralChangeLogService;
import com.xjw.service.mail.MailService;
import com.xjw.service.notice.NoticeService;
import com.xjw.service.order.WithdrawalOrderService;
import com.xjw.service.sys.FinalResourcesValuesService;
import com.xjw.service.sys.FunctionService;
import com.xjw.service.sys.UserService;
import com.xjw.service.user.MemberRemarkService;
import com.xjw.service.user.MemberService;
import com.xjw.service.user.UserAccountChangeService;
import com.xjw.util.FreeMarkerConstant;
import com.xjw.util.SequenceBuilder;
import com.xjw.util.SequenceBuilder.SequenceType;
import com.xjw.utility.BizException;
import com.xjw.utility.ContextUrlManager;
import com.xjw.utility.CurrentUserHolder;
import com.xjw.utility.DataMath;
import com.xjw.utility.StringUtil;

@Service
public class WithdrawalOrderServiceImpl extends BaseServiceImpl<WithdrawalOrder> implements WithdrawalOrderService {
	@Resource
	private WithdrawalOrderDao withdrawalOrderDao;
	@Resource
	private UserAccountChangeService accountIntegralService;
	@Resource
	private UserAccountIntegralChangeLogService userAccountIntegralChangeLogService;
	@Resource
	private UserBankInfoService userBankInfoService;
	@Resource
	private UserService userService;
	@Resource
	private FunctionService functionService;
	@Resource
	private NoticeService noticeService;
	@Resource
	private MemberRemarkService memberRemarkService;
	@Resource
	private FinalResourcesValuesService finalResourcesValuesService;
	@Resource
	private MailService mailService;
	@Resource
	private MemberService memberService;

	public BigDecimal selectAmountByAgent(Map<String, Object> params) {
		return withdrawalOrderDao.selectAmountByAgent(params);
	}

	public WithdrawalOrder createWithdrawalOrder(WithdrawalOrderVo withdrawalOrderVo) throws Exception {
		Date dateTime = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 用户总账户
		Map<String, Object> conditionParam = new HashMap<String, Object>();
		conditionParam.put("userId", withdrawalOrderVo.getUserId());
		AccountIntegral accountIntegral = accountIntegralService.selectOne(conditionParam);

		if (accountIntegral.getTotalMoney().doubleValue() >= withdrawalOrderVo.getAmount().doubleValue()) {
			User user = userService.selectById(withdrawalOrderVo.getUserId());

			// 拼装的银行详细地址
			StringBuffer addressBuf = new StringBuffer();
			addressBuf.append(withdrawalOrderVo.getProvince()).append(" ").append(withdrawalOrderVo.getCity())
					.append(" ").append(withdrawalOrderVo.getAddress());

			String isDefaultBankCardInfo = withdrawalOrderVo.getIsDefaultBankCardInfo();
			// 前端页面是否设置默认银行卡信息
			if (YesORNoEnum.YES.getCode().equals(isDefaultBankCardInfo)) {
				// 设置新的用户银行卡信息
				UserBankInfo userBankInfo = userBankInfoService.findUserBankInfoById(withdrawalOrderVo.getUserId());
				// 用户卡存在 直接更新
				if (userBankInfo != null) {
					userBankInfo.setUserId(user.getId());
					userBankInfo.setAccountName(user.getUserName());
					userBankInfo.setBankType(withdrawalOrderVo.getBankType());
					userBankInfo.setBankCardNo(withdrawalOrderVo.getCardNo());
					userBankInfo.setBankAddress(addressBuf.toString());
					userBankInfoService.update(userBankInfo);
				} else {
					userBankInfo = new UserBankInfo();
					userBankInfo.setUserId(user.getId());
					userBankInfo.setAccountName(user.getUserName());
					userBankInfo.setBankType(withdrawalOrderVo.getBankType());
					userBankInfo.setBankCardNo(withdrawalOrderVo.getCardNo());
					userBankInfo.setBankAddress(addressBuf.toString());
					userBankInfo.setType(Integer.valueOf(UserBankInfoTypeEnum.OUTSIDE.getCode()));
					userBankInfo.setIsDefault(Integer.valueOf(YesORNoEnum.YES.getCode()));
					userBankInfoService.save(userBankInfo);
				}
			}
			// 提款订单
			WithdrawalOrder withdrawalOrder = new WithdrawalOrder();
			withdrawalOrder.setIpAddress(withdrawalOrderVo.getAddress());
			withdrawalOrder.setOrderNo(SequenceBuilder.next(SequenceType.WD));
			withdrawalOrder.setUserId(withdrawalOrderVo.getUserId());
			withdrawalOrder.setToBankType(withdrawalOrderVo.getBankType());
			withdrawalOrder.setToBankAccount(user.getUserName());
			withdrawalOrder.setToBankCard(withdrawalOrderVo.getCardNo());
			withdrawalOrder.setToBankAddress(addressBuf.toString());
			withdrawalOrder.setTradeAmount(withdrawalOrderVo.getAmount());
			withdrawalOrder.setIpAddress(withdrawalOrderVo.getIpAddress());
			withdrawalOrder.setStatus(Integer.valueOf(OrderStatusEnum.DRAFT.getCode()));
			withdrawalOrder.setCreateTime(dateTime);
			withdrawalOrder = this.save(withdrawalOrder);

			BigDecimal totalMoney = DataMath.sub(accountIntegral.getTotalMoney().doubleValue(),
					withdrawalOrderVo.getAmount().doubleValue());
			accountIntegral.setTotalMoney(totalMoney);
			accountIntegralService.update(accountIntegral);

			/** 插入账变日志 **/
			UserAccountIntegralChangeLog userAccountIntegralChangeLog = new UserAccountIntegralChangeLog();
			// 表名 表ID
			userAccountIntegralChangeLog.setTableName(Constant.FinalTableName.WITHDRAWAL);
			userAccountIntegralChangeLog.setBusinessTableId(withdrawalOrder.getId());
			// 账变类型
			userAccountIntegralChangeLog
					.setType(Integer.valueOf(AccountIntegralChangeLogTypeEnum.WITHDRAWAL_APPLY.getCode()));
			// 收入
			userAccountIntegralChangeLog.setMoney(DataMath.negative(withdrawalOrderVo.getAmount()));
			userAccountIntegralChangeLog.setTotalMoney(totalMoney);

			userAccountIntegralChangeLog.setUserId(withdrawalOrder.getUserId());
			userAccountIntegralChangeLog.setRemark(withdrawalOrder.getRemark());
			userAccountIntegralChangeLog.setOrderNo(withdrawalOrder.getOrderNo());
			userAccountIntegralChangeLog.setIpAddress(withdrawalOrder.getIpAddress());
			userAccountIntegralChangeLog.setGameType(Integer.valueOf(PlatformTypeEnum.MAIN.getCode()));
			userAccountIntegralChangeLogService.save(userAccountIntegralChangeLog);

			/** 添加风控消息提醒 */
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("code", Constant.FinalFunctionCode.WITHDRAWAL_CODE);
			Function function = functionService.selectOne(condition);

			// 查询部门消息
			List<User> userList = userService.getUserListByUserType(
					StringUtil.getListFromStr(UserTypeAllEnum.FK.getCode() + "," + UserTypeAllEnum.KF.getCode()));

			Map<String, Object> param = new HashMap<String, Object>();
			param.put("userName", user.getLoginName());
			param.put("createTime", format.format(dateTime));
			param.put("money", withdrawalOrder.getTradeAmount());
			if (function != null) {
				param.put("url", ContextUrlManager.getBasePath() + function.getUrl());
				param.put("orderNo", withdrawalOrder.getOrderNo());
				noticeService.saveSendNotice(param, userList, NoticeCodeEnum.WITHDRAWAL_FK_APPROVE.getCode());
			}
			return withdrawalOrder;
		} else {
			throw new BizException("Insufficient account balance!");
		}
	}

	public synchronized void updateExamineSucc(User user, WithdrawalOrderForm withdrawalOrderForm) throws BizException {
		Long id = Long.valueOf(withdrawalOrderForm.getId());
		WithdrawalOrder withdrawalOrder = this.selectById(id);

		if (withdrawalOrder != null
				&& OrderStatusEnum.DRAFT.getCode().equals(String.valueOf(withdrawalOrder.getStatus()))) { // 避免重复提交
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("id", id);
			if (UserTypeAllEnum.FK.getCode().equals(withdrawalOrderForm.getUserType())) {
				param.put("riskUser", CurrentUserHolder.getCurrentUserId());
				param.put("riskTime", new Date());
			} else {
				UserBankInfo userBankInfo = userBankInfoService
						.selectById(Long.valueOf(withdrawalOrderForm.getFromBankCard()));
				param.put("fromBankId", userBankInfo.getId());
				param.put("fromBankType", userBankInfo.getType());
				param.put("fromBankAccount", userBankInfo.getAccountName());
				param.put("fromBankCard", userBankInfo.getBankCardNo());
				param.put("poundage", withdrawalOrderForm.getPoundage());

				param.put("financeUser", CurrentUserHolder.getCurrentUserId());
				param.put("financeTime", new Date());
				param.put("status", OrderStatusEnum.SUCCESS.getCode());
			}
			this.update(param);

			/** ------------------添加财务消息提醒 */
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("code", Constant.FinalFunctionCode.WITHDRAWAL_CODE);
			Function function = functionService.selectOne(condition);

			// 查询部门消息
			List<User> userList = userService.getUserListByUserType(UserTypeAllEnum.CW.getCode());
			User member = userService.selectById(withdrawalOrder.getUserId());
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Map<String, Object> transParam = new HashMap<String, Object>();
			transParam.put("userName", member.getLoginName());
			transParam.put("createTime", format.format(withdrawalOrder.getCreateTime()));
			transParam.put("money", withdrawalOrder.getTradeAmount());
			if (function != null) {
				transParam.put("url", ContextUrlManager.getBasePath() + function.getUrl());
				transParam.put("orderNo", withdrawalOrder.getOrderNo());
				noticeService.saveSendNotice(transParam, userList, NoticeCodeEnum.WITHDRAWAL_CW_APPROVE.getCode());
			}
			/** -----------------添加财务消息提醒 */
			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("orderNo", withdrawalOrder.getOrderNo());// 提款编号
			dataMap.put("loginName", withdrawalOrder.getLoginName()); // 会员账号
			dataMap.put("toBankAccount", withdrawalOrder.getToBankAccount()); // 提款人姓名
			Map<String, Object> map = finalResourcesValuesService.getMapForList("USER_BANK_TYPE");
			dataMap.put("toBankType", map.get(String.valueOf(withdrawalOrder.getToBankType())) ); //提款银行
			dataMap.put("toBankCard", withdrawalOrder.getToBankCard()); 	//提款账号
			dataMap.put("tradeAmount", withdrawalOrder.getTradeAmount()); 	//提款金额
			
			//发邮件
			Email email = new Email();
			//Member memberinfo = memberService.selectById(withdrawalOrder.getUserId());
			//EncryptUtil.decode(Constant.DateEncryptManage.EMAIL_PWD, memberinfo.getEmail()));
			email.setTo("fa@88tianxia.com");
			String dayString = DateFormatUtils.format(new Date(), "yyyy-MM-dd");
			email.setSubject(dayString + " 提款订单邮件 ");
			email.setContent(FreeMarkerConstant.WITHDRAWAL_SENDMAIL);
			mailService.sendMailByFreemarker(email, dataMap);
		}
	}

	public void updateExamineFail(WithdrawalOrderForm withdrawalOrderForm) throws BizException {
		WithdrawalOrder withdrawalOrder = this.selectById(Long.valueOf(withdrawalOrderForm.getId()));

		if (withdrawalOrder != null
				&& OrderStatusEnum.DRAFT.getCode().equals(String.valueOf(withdrawalOrder.getStatus()))) { // 避免重复提交
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("id", withdrawalOrderForm.getId());
			// MemberRemark memberRemark = new MemberRemark();
			if (withdrawalOrderForm.getUserType().equals(UserTypeAllEnum.FK.getCode())) {
				param.put("riskUser", CurrentUserHolder.getCurrentUserId());
				param.put("riskTime", new Date());
				// 风控拒绝
				// memberRemark.setTitleType(Integer.parseInt(RemarkTitleTypeEnum.FK.getCode()));
			} else {
				param.put("financeUser", CurrentUserHolder.getCurrentUserId());
				param.put("financeTime", new Date());
				// 财务拒绝
				// memberRemark.setTitleType(Integer.parseInt(RemarkTitleTypeEnum.CW.getCode()));
			}

			// 修改状态为审核失败
			param.put("status", OrderStatusEnum.FAIL.getCode());
			param.put("remark", withdrawalOrderForm.getRemark());
			this.update(param);

			// 记录失败备注
			// memberRemark.setRemark(withdrawalOrderForm.getRemark());
			// memberRemark.setUserId(withdrawalOrder.getUserId());
			// memberRemark.setStatus(Integer.parseInt(StatusEnum.DEFAULT.getCode()));
			// memberRemarkService.save(memberRemark);

			// 查询订单金额
			BigDecimal money = withdrawalOrder.getTradeAmount();// 订单金额

			// 修改用户账户账户金额
			Map<String, Object> conditionParam = new HashMap<String, Object>();
			conditionParam.put("userId", withdrawalOrder.getUserId());
			AccountIntegral accountIntegral = accountIntegralService.selectOne(conditionParam);
			BigDecimal totalMoney = DataMath.add(accountIntegral.getTotalMoney().doubleValue(), money.doubleValue());

			accountIntegral
					.setTotalMoney(DataMath.add(accountIntegral.getTotalMoney().doubleValue(), money.doubleValue()));
			accountIntegralService.update(accountIntegral);

			// 添加用户账变日志
			UserAccountIntegralChangeLog userAccountIntegralChangeLog = new UserAccountIntegralChangeLog();
			userAccountIntegralChangeLog.setTableName("user_withdrawal_order");
			userAccountIntegralChangeLog.setBusinessTableId(withdrawalOrder.getId());
			userAccountIntegralChangeLog.setUserId(withdrawalOrder.getUserId());
			userAccountIntegralChangeLog.setMoney(money);

			// 表名 表ID
			userAccountIntegralChangeLog.setTableName(Constant.FinalTableName.WITHDRAWAL);
			userAccountIntegralChangeLog.setBusinessTableId(withdrawalOrder.getId());
			// 账变类型
			userAccountIntegralChangeLog
					.setType(Integer.valueOf(AccountIntegralChangeLogTypeEnum.WITHDRAWAL_FAILURE.getCode()));
			// 收入
			userAccountIntegralChangeLog.setMoney(money);
			userAccountIntegralChangeLog.setTotalMoney(totalMoney);

			userAccountIntegralChangeLog.setUserId(withdrawalOrder.getUserId());
			userAccountIntegralChangeLog.setRemark(withdrawalOrder.getRemark());
			userAccountIntegralChangeLog.setOrderNo(withdrawalOrder.getOrderNo());
			userAccountIntegralChangeLog.setIpAddress(withdrawalOrder.getIpAddress());
			userAccountIntegralChangeLogService.save(userAccountIntegralChangeLog);
		}
	}

	public synchronized void updateByAuditSuccess(Long id) throws BizException {
		WithdrawalOrder withdrawalOrder = this.selectById(id);
		if (withdrawalOrder == null
				|| !OrderStatusEnum.DRAFT.getCode().equals(String.valueOf(withdrawalOrder.getStatus()))) { // 避免重复提交
			return;
		}

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", withdrawalOrder.getId());
		params.put("riskUser", CurrentUserHolder.getCurrentUserId());
		params.put("riskTime", new Date());
		this.update(params);

		/****** 添加财务消息提醒 begin ******/
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("code", Constant.FinalFunctionCode.WITHDRAWAL_CODE);
		Function function = functionService.selectOne(condition);

		// 查询部门消息
		List<User> userList = userService.getUserListByUserType(UserTypeAllEnum.CW.getCode());
		User member = userService.selectById(withdrawalOrder.getUserId());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Map<String, Object> transParam = new HashMap<String, Object>();
		transParam.put("userName", member.getLoginName());
		transParam.put("createTime", format.format(withdrawalOrder.getCreateTime()));
		transParam.put("money", withdrawalOrder.getTradeAmount());
		if (function != null) {
			transParam.put("url", ContextUrlManager.getBasePath() + function.getUrl());
			transParam.put("orderNo", withdrawalOrder.getOrderNo());
			noticeService.saveSendNotice(transParam, userList, NoticeCodeEnum.WITHDRAWAL_CW_APPROVE.getCode());
		}
		/****** 添加财务消息提醒 end ******/
	}

	public synchronized void updateByAuditFail(Long id, String remark) throws BizException {
		WithdrawalOrder withdrawalOrder = this.selectById(id);
		if (withdrawalOrder == null
				|| !OrderStatusEnum.DRAFT.getCode().equals(String.valueOf(withdrawalOrder.getStatus()))) { // 避免重复提交
			return;
		}

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", withdrawalOrder.getId());
		param.put("status", OrderStatusEnum.FAIL.getCode());
		param.put("remark", remark);
		param.put("riskUser", CurrentUserHolder.getCurrentUserId());
		param.put("riskTime", new Date());
		this.update(param);

		// MemberRemark memberRemark = new MemberRemark();
		// memberRemark.setTitleType(Integer.parseInt(RemarkTitleTypeEnum.FK.getCode()));
		// memberRemark.setRemark(remark);
		// memberRemark.setUserId(withdrawalOrder.getUserId());
		// memberRemark.setStatus(Integer.parseInt(StatusEnum.DEFAULT.getCode()));
		// memberRemarkService.save(memberRemark);

		// 查询订单金额
		BigDecimal money = withdrawalOrder.getTradeAmount();// 订单金额

		// 修改用户账户账户金额
		Map<String, Object> conditionParam = new HashMap<String, Object>();
		conditionParam.put("userId", withdrawalOrder.getUserId());
		AccountIntegral accountIntegral = accountIntegralService.selectOne(conditionParam);
		BigDecimal totalMoney = DataMath.add(accountIntegral.getTotalMoney().doubleValue(), money.doubleValue());
		accountIntegral.setTotalMoney(DataMath.add(accountIntegral.getTotalMoney().doubleValue(), money.doubleValue()));
		accountIntegralService.update(accountIntegral);

		// 添加用户账变日志
		UserAccountIntegralChangeLog userAccountIntegralChangeLog = new UserAccountIntegralChangeLog();
		userAccountIntegralChangeLog.setTableName(Constant.FinalTableName.WITHDRAWAL); // 表名
		userAccountIntegralChangeLog.setBusinessTableId(withdrawalOrder.getId()); // 表ID
		userAccountIntegralChangeLog
				.setType(Integer.valueOf(AccountIntegralChangeLogTypeEnum.WITHDRAWAL_FAILURE.getCode())); // 账变类型
		userAccountIntegralChangeLog.setMoney(money); // 收入
		userAccountIntegralChangeLog.setTotalMoney(totalMoney);
		userAccountIntegralChangeLog.setUserId(withdrawalOrder.getUserId());
		userAccountIntegralChangeLog.setRemark(withdrawalOrder.getRemark());
		userAccountIntegralChangeLog.setOrderNo(withdrawalOrder.getOrderNo());
		userAccountIntegralChangeLog.setIpAddress(withdrawalOrder.getIpAddress());
		userAccountIntegralChangeLogService.save(userAccountIntegralChangeLog);
	}

	@Override
	public Class<WithdrawalOrder> getClazz() {
		return WithdrawalOrder.class;
	}

	@Override
	public BaseDaoImpl<WithdrawalOrder> baseDao() {
		return withdrawalOrderDao;
	}

	public List<WithdrawalTimeCount> getWithdrawalOrderListByTime(Map<String, Object> params) {
		List<WithdrawalTimeCount> list = new ArrayList<WithdrawalTimeCount>();
		
		List<WithdrawalFinance> withFinList = withdrawalOrderDao.selectCountWithdrawalFinance(params);
		if(null != withFinList && withFinList.size() > 0 ){
			for (WithdrawalFinance withdrawalFinance : withFinList) {
				WithdrawalTimeCount wtc = new WithdrawalTimeCount();
				wtc.setType("finance");
				wtc.setLoginName(withdrawalFinance.getLoginName());
				wtc.setUserId(withdrawalFinance.getFinanceUser());
				wtc.setCountUser(withdrawalFinance.getCountFinance());
				list.add(wtc);
			}
		}
		
		List<WithdrawalRisk> withRiskList = withdrawalOrderDao.selectCountWithdrawalRisk(params);
		if(null != withRiskList && withRiskList.size() > 0 ){
			for (WithdrawalRisk withdrawalRisk : withRiskList) {
				WithdrawalTimeCount wtc = new WithdrawalTimeCount();
				wtc.setType("risk");
				wtc.setLoginName(withdrawalRisk.getLoginName());
				wtc.setUserId(withdrawalRisk.getRiskUser());
				wtc.setCountUser(withdrawalRisk.getCountRisk());
				list.add(wtc);
			}
		}
		
		return list;
	}

	public List<DrawalCount> getDrawalCount(Map<String, Object> params) {
		return withdrawalOrderDao.getDrawalCount(params);
	}
}
