package com.xjw.dao.user;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.entity.po.user.FundAdjustActivityCount;
import com.xjw.entity.po.user.MemberMoneyChange;

@Repository
public class MemberMoneyChangeDao extends BaseDaoImpl<MemberMoneyChange>{
	
	public BigDecimal selectSumAmount(Map<String, Object> params){
		return super.getSqlSession().selectOne("MemberMoneyChange.selectSumAmount", params);
	}

	public BigDecimal selectSumIntegralByJoinAct(Long userId, Integer actType, Integer platformType, String joinDate){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("actType", actType);
		params.put("platformType", platformType);
		params.put("joinDate", joinDate);
		return super.getSqlSession().selectOne("MemberMoneyChange.selectSumIntegralByJoinAct", params);
	}	
	
	public List<MemberMoneyChange> selectByJoinAct(Long userId, Integer actType, Integer platformType, String joinDate){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("actType", actType);
		params.put("platformType", platformType);
		params.put("joinDate", joinDate);
		return super.getSqlSession().selectList("MemberMoneyChange.selectByJoinAct", params);
	}	
	
	/** 查询代理的下属会员存款总额 */
	public BigDecimal selectAmountByAgent(Map<String, Object> params){
		return super.getSqlSession().selectOne("MemberMoneyChange.selectAmountByAgent", params);
	}
	
	/** 查询资金调整活动总金额 */
	public List<FundAdjustActivityCount> selectHDAmount(Map<String, Object> params){
		return super.getSqlSession().selectList("MemberMoneyChange.selectHDAmount", params);
	}
	
	/** 查询资金调整返水总金额 */
	public BigDecimal selectFSAmount(Map<String, Object> params){
		return super.getSqlSession().selectOne("MemberMoneyChange.selectFSAmount", params);
	}
	
	/** 查询资金调整特殊奖金总金额 */
	public BigDecimal selectTSJJAmount(Map<String, Object> params){
		return super.getSqlSession().selectOne("MemberMoneyChange.selectTSJJAmount", params);
	}
	
	/** 查询资金调整其它总金额 */
	public BigDecimal selectQTAmount(Map<String, Object> params){
		return super.getSqlSession().selectOne("MemberMoneyChange.selectQTAmount", params);
	}
}
