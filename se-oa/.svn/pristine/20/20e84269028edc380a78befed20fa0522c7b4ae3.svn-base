package com.xjw.service.user.impl;

import java.math.BigDecimal;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.user.OfficialMemberDao;
import com.xjw.entity.po.user.OfficialMember;
import com.xjw.service.user.OfficialMemberService;

@Service
public class OfficialMemberServiceImpl extends BaseServiceImpl<OfficialMember> implements OfficialMemberService {
	@Resource
	private OfficialMemberDao officialMemberDao;
	
	@Override
	public BaseDaoImpl<OfficialMember> baseDao() {
		return officialMemberDao;
	}

	@Override
	public Class<OfficialMember> getClazz() {
		return OfficialMember.class;
	}

	public int selectCountByOfficialMember(Map<String, Object> params) {
		return officialMemberDao.selectCountByOfficialMember(params);
	}
	
	/**
	 * 今日投注总额
	 */
	public BigDecimal selectSumBetAmount(Map<String, Object> params) {
		BigDecimal aggjBetAmount = officialMemberDao.selectSumBetAmountByAggj(params);
		BigDecimal agjsBetAmount = officialMemberDao.selectSumBetAmountByAgjs(params);
		BigDecimal ptBetAmount = officialMemberDao.selectSumBetAmountByPt(params);
		BigDecimal mgBetAmount = officialMemberDao.selectSumBetAmountByMg(params);
		BigDecimal xinBetAmount = officialMemberDao.selectSumBetAmountByXin(params);
		BigDecimal fishBetAmount = officialMemberDao.selectSumBetAmountByFish(params);
		BigDecimal sbBetAmount = officialMemberDao.selectSumBetAmountBySb(params);
		BigDecimal qpBetAmount = officialMemberDao.selectSumBetAmountByQp(params);
		BigDecimal ttgBetAmount = officialMemberDao.selectSumBetAmountByTtg(params);
		BigDecimal endoBetAmount = officialMemberDao.selectSumBetAmountByEndo(params);

		BigDecimal sumBetAmount = aggjBetAmount.add(agjsBetAmount).add(ptBetAmount).add(mgBetAmount).add(xinBetAmount)
				.add(fishBetAmount).add(sbBetAmount).add(qpBetAmount).add(ttgBetAmount).add(endoBetAmount);

		return sumBetAmount;
	}
	
	public BigDecimal selectAmountByOfficialMember(Map<String, Object> params) {
		return officialMemberDao.selectAmountByOfficialMember(params);
	}
	
	public BigDecimal selectWithdrawalAmountByOfficialMember(Map<String, Object> params) {
		return officialMemberDao.selectWithdrawalAmountByOfficialMember(params);
	}
	
	public BigDecimal selectMMCAmountByOfficialMember(Map<String, Object> params){
		return officialMemberDao.selectMMCAmountByOfficialMember(params);
	}
	
	public long selectAllCountByOfficialUser(Map<String, Object> params){
		return officialMemberDao.selectAllCountByOfficialUser(params);
	}
}
