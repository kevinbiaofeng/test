package com.xjw.dao.user;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.entity.po.user.OfficialMember;

@Repository
public class OfficialMemberDao extends BaseDaoImpl<OfficialMember>{
	public int selectCountByOfficialMember(Map<String, Object> params){
		return super.getSqlSession().selectOne("OfficialMember.selectCountByOfficialMember", params);
	}
	
	public BigDecimal selectSumBetAmountByAggj(Map<String, Object> params) {
		return super.getSqlSession().selectOne("OfficialMember.selectSumBetAmountByAggj", params);
	}

	public BigDecimal selectSumBetAmountByAgjs(Map<String, Object> params) {
		return super.getSqlSession().selectOne("OfficialMember.selectSumBetAmountByAgjs", params);
	}

	public BigDecimal selectSumBetAmountByPt(Map<String, Object> params) {
		return super.getSqlSession().selectOne("OfficialMember.selectSumBetAmountByPt", params);
	}

	public BigDecimal selectSumBetAmountByMg(Map<String, Object> params) {
		return super.getSqlSession().selectOne("OfficialMember.selectSumBetAmountByMg", params);
	}

	public BigDecimal selectSumBetAmountByXin(Map<String, Object> params) {
		return super.getSqlSession().selectOne("OfficialMember.selectSumBetAmountByXin", params);
	}

	public BigDecimal selectSumBetAmountByFish(Map<String, Object> params) {
		return super.getSqlSession().selectOne("OfficialMember.selectSumBetAmountByFish", params);
	}

	public BigDecimal selectSumBetAmountBySb(Map<String, Object> params) {
		return super.getSqlSession().selectOne("OfficialMember.selectSumBetAmountBySb", params);
	}

	public BigDecimal selectSumBetAmountByQp(Map<String, Object> params) {
		return super.getSqlSession().selectOne("OfficialMember.selectSumBetAmountByQp", params);
	}

	public BigDecimal selectSumBetAmountByTtg(Map<String, Object> params) {
		return super.getSqlSession().selectOne("OfficialMember.selectSumBetAmountByTtg", params);
	}

	public BigDecimal selectSumBetAmountByEndo(Map<String, Object> params) {
		return super.getSqlSession().selectOne("OfficialMember.selectSumBetAmountByEndo", params);
	}
	
	/** 查询官网的会员存款总额  */
	public BigDecimal selectAmountByOfficialMember(Map<String, Object> params){
		return super.getSqlSession().selectOne("OfficialMember.selectDepositAmountByOfficialMember", params);
	}
	
	/** 查询官网的会员提款总额 */
	public BigDecimal selectWithdrawalAmountByOfficialMember(Map<String, Object> params){
		return super.getSqlSession().selectOne("OfficialMember.selectWithdrawalAmountByOfficialMember", params);
	}
	
	/** 查询官网的会员存款总额 */
	public BigDecimal selectMMCAmountByOfficialMember(Map<String, Object> params){
		return super.getSqlSession().selectOne("OfficialMember.selectMMCAmountByOfficialMember", params);
	}
	
	/** 查询官网会员有存款的人员，也叫活跃会员  */
	public long selectAllCountByOfficialUser(Map<String, Object> params){
		return super.getSqlSession().selectOne("OfficialMember.selectAllCountByOfficialUser", params);
	}
}
