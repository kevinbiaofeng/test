package com.xjw.service.user.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.common.util.Constant;
import com.xjw.dao.user.MemberMoneyChangeDao;
import com.xjw.entity.po.log.UserAccountIntegralChangeLog;
import com.xjw.entity.po.user.AccountIntegral;
import com.xjw.entity.po.user.FundAdjustActivityCount;
import com.xjw.entity.po.user.MemberMoneyChange;
import com.xjw.kzenum.log.AccountIntegralChangeLogTypeEnum;
import com.xjw.service.log.UserAccountIntegralChangeLogService;
import com.xjw.service.user.MemberMoneyChangeService;
import com.xjw.service.user.MemberRemarkService;
import com.xjw.service.user.UserAccountChangeService;
import com.xjw.utility.DataMath;

@Service
public class MemberMoneyChangeServiceImpl extends BaseServiceImpl<MemberMoneyChange> implements MemberMoneyChangeService {
	@Resource
	private MemberMoneyChangeDao memberMoneyChangeDao;
	@Resource
	private MemberRemarkService memberRemarkService;
	@Resource
	private UserAccountChangeService accountIntegralService;
	@Resource
	private UserAccountIntegralChangeLogService userAccountIntegralChangeLogService;
	
	public String saveMoneyChangeAndUpdateAccount(MemberMoneyChange memberMoneyChange) throws Exception{
//		String orderNo = memberMoneyChange.getDepositOrderNo();
//		if(StringUtils.isNotEmpty(orderNo)){
//			conditionParam.put("depositOrderNo", memberMoneyChange.getDepositOrderNo());
//			long count = this.selectAllCount(conditionParam);
//			if(count > 0){
//				return "10002";  //该订单已参加过其他活动
//			}
//		}
		
		//资金调整后修改账户金额
		BigDecimal money = memberMoneyChange.getMoney();
		BigDecimal integral = memberMoneyChange.getIntegral();
//		if(PlatformTypeEnum.MAIN.getCode().equals(String.valueOf(memberMoneyChange.getPlatformType()))){
		Map<String, Object> conditionParam = new HashMap<String, Object>();
		conditionParam.clear();
		conditionParam.put("userId", memberMoneyChange.getUserId());
		AccountIntegral accountIntegral = accountIntegralService.selectOne(conditionParam);
		if(money.compareTo(BigDecimal.ZERO) == -1){
			if(accountIntegral.getTotalMoney().compareTo(DataMath.negative(money)) == -1){
				return "10001";  //扣除金额大于总金额
			}
		}
		memberMoneyChange = this.save(memberMoneyChange);
		
//		if(null == memberMoneyChange.getActId() && StringUtil.isBlank(memberMoneyChange.getDepositOrderNo())){
//			MemberRemark memberRemark = new MemberRemark();
//			memberRemark.setUserId(memberMoneyChange.getUserId());
//			memberRemark.setRemark(memberMoneyChange.getRemark());
//			memberRemark.setCreateUser(memberMoneyChange.getCreateUser());
//			memberRemark.setTitleType(Integer.valueOf(RemarkTitleTypeEnum.ZC.getCode()));
//			memberRemarkService.save(memberRemark);
//		}
		
		//变化后的总账户余额
		BigDecimal totalMoney = DataMath.add(accountIntegral.getTotalMoney().doubleValue(), money.doubleValue());
		accountIntegral.setTotalMoney(totalMoney);
		accountIntegral.setIntegral(DataMath.add(accountIntegral.getIntegral().doubleValue(), integral.doubleValue()));
		accountIntegralService.update(accountIntegral);
		
		/**插入账变日志**/
		UserAccountIntegralChangeLog userAccountIntegralChangeLog = new UserAccountIntegralChangeLog();
		//表名 表ID
		userAccountIntegralChangeLog.setTableName(Constant.FinalTableName.MEMBER_MONEY_CHANGE);
		userAccountIntegralChangeLog.setBusinessTableId(memberMoneyChange.getId());
		//账变类型
		userAccountIntegralChangeLog.setType(Integer.valueOf(AccountIntegralChangeLogTypeEnum.MONEY_CHANGE.getCode()));
		//收入
		userAccountIntegralChangeLog.setMoney(money);
		userAccountIntegralChangeLog.setIntegral(integral);
		userAccountIntegralChangeLog.setTotalMoney(totalMoney);
		userAccountIntegralChangeLog.setOrderNo(memberMoneyChange.getDepositOrderNo());
		userAccountIntegralChangeLog.setMultiple(memberMoneyChange.getMultiple());
		userAccountIntegralChangeLog.setChangeType(memberMoneyChange.getChangeType());
		userAccountIntegralChangeLog.setActId(memberMoneyChange.getActId());
		userAccountIntegralChangeLog.setUserId(memberMoneyChange.getUserId());
		userAccountIntegralChangeLog.setRemark(memberMoneyChange.getRemark());
		userAccountIntegralChangeLogService.save(userAccountIntegralChangeLog);
		return "1";
//		}else{
//			memberMoneyChange.setStartTime(new Date());
//			result = platformTransferService.createTransferOrder(String.valueOf(memberMoneyChange.getUserId()), String.valueOf(memberMoneyChange.getPlatformType()), money, (money.compareTo(BigDecimal.ZERO) != -1 ? PlatformTransferTypeEnum.IN.getCode() : PlatformTransferTypeEnum.OUT.getCode()), memberMoneyChange.getChangeType().equals(Integer.valueOf(MemberMoneyChangeTypeEnum.FS.getCode()))?FromFunctionEnum.FS.getCode():FromFunctionEnum.ZJTZ.getCode());
//		}
//		
//		if(result != null && String.valueOf(result.get("code")).equals("1")){
//			memberMoneyChange = this.save(memberMoneyChange);
//			return "1";
//		}else{
//			return "0";
//		}
	}
	
	public static void main(String[] args) {
		System.out.println(new BigDecimal(-2).compareTo(BigDecimal.ZERO) != -1);
	}
	
	public BigDecimal selectAmountByAgent(Map<String, Object> params){
		return memberMoneyChangeDao.selectAmountByAgent(params);
	}
	
	@Override
	public Class<MemberMoneyChange> getClazz() {
		return MemberMoneyChange.class;
	}

	@Override
	public BaseDaoImpl<MemberMoneyChange> baseDao() {
		return memberMoneyChangeDao;
	}

	public List<FundAdjustActivityCount> selectHDAmount(Map<String, Object> params) {
		return memberMoneyChangeDao.selectHDAmount(params);
	}

	public BigDecimal selectFSAmount(Map<String, Object> params) {
		return memberMoneyChangeDao.selectFSAmount(params);
	}

	public BigDecimal selectTSJJAmount(Map<String, Object> params) {
		return memberMoneyChangeDao.selectTSJJAmount(params);
	}

	public BigDecimal selectQTAmount(Map<String, Object> params) {
		return memberMoneyChangeDao.selectQTAmount(params);
	}

}
