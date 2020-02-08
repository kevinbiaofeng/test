package com.xjw.service.user;

import java.math.BigDecimal;
import java.util.Map;

import com.xjw.base.service.BaseServcie;
import com.xjw.entity.po.user.OfficialMember;

public interface OfficialMemberService extends BaseServcie<OfficialMember>{
	//查询官网会员的会员数量
	public int selectCountByOfficialMember(Map<String, Object> params);
	//今日投注总额
	public BigDecimal selectSumBetAmount(Map<String, Object> params);
	//查询官网的会员存款总额 
	public BigDecimal selectAmountByOfficialMember(Map<String, Object> params);
	//查询官网的会员提款总额 
	public BigDecimal selectWithdrawalAmountByOfficialMember(Map<String, Object> params);
	// 查询官网的会员存款总额 
	public BigDecimal selectMMCAmountByOfficialMember(Map<String, Object> params);
	//查询官网会员有存款的人员，也叫活跃会员
	public long selectAllCountByOfficialUser(Map<String, Object> params);
	
}
