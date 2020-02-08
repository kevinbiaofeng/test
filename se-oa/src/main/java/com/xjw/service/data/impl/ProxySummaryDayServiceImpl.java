package com.xjw.service.data.impl;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.data.ProxySummaryDayDao;
import com.xjw.dao.order.DepositOrderDao;
import com.xjw.dao.order.WithdrawalOrderDao;
import com.xjw.dao.user.AgentDao;
import com.xjw.dao.user.MemberDao;
import com.xjw.entity.po.data.ProxySummaryDay;
import com.xjw.entity.po.user.Agent;
import com.xjw.service.data.ProxySummaryDayService;
import com.xjw.utility.BizException;

@Service
public class ProxySummaryDayServiceImpl extends BaseServiceImpl<ProxySummaryDay> implements ProxySummaryDayService {

	/** 指定的代理账号 */
	private static final List<Long> AGENT_USER_ID_LIST = Arrays.asList(new Long[]{2987L, 3452L, 4105L, 4106L});
	
	@Autowired
	private ProxySummaryDayDao proxySummaryDayDao;
	@Autowired
	private AgentDao agentDao;
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private DepositOrderDao depositOrderDao;
	@Autowired
	private WithdrawalOrderDao withdrawalOrderDao;
	
	public void save(Date dayTime) throws BizException{
		String queryString = DateFormatUtils.format(dayTime, "yyyy-MM-dd");
		
		String beginTime = queryString + " 00:00:00";
		String endTime = queryString + " 23:59:59";
		Calendar nowTime = Calendar.getInstance();
		
		for(Long agentUserId : AGENT_USER_ID_LIST){
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("beginTime", beginTime);
			params.put("endTime", endTime);
			params.put("parentId", agentUserId);
			
			//会员总数
			Long userCount = memberDao.selectAllCount("Member.selectAllCount", params);
			//存款总额
			BigDecimal depositAmount = depositOrderDao.selectSumAmount(params);
			//提款总额
			BigDecimal withdrawAmount = withdrawalOrderDao.selectSumAmount(params);
			
			//代理用户
			Agent agent = agentDao.selectById("Agent.selectById", agentUserId);
			
			ProxySummaryDay proxySummaryDay = new ProxySummaryDay();
			proxySummaryDay.setUserId(agent.getId());
			proxySummaryDay.setLoginName(agent.getLoginName());
			proxySummaryDay.setUserCount(userCount.intValue());
			proxySummaryDay.setDepositAmount(depositAmount);
			proxySummaryDay.setWithdrawAmount(withdrawAmount);
			proxySummaryDay.setDayTime(dayTime);
			proxySummaryDay.setCreateTime(nowTime.getTime());
			proxySummaryDayDao.save("ProxySummaryDay.save", proxySummaryDay);
		}
	}

	public ProxySummaryDayDao getProxySummaryDayDao() {
		return proxySummaryDayDao;
	}

	public void setProxySummaryDayDao(ProxySummaryDayDao proxySummaryDayDao) {
		this.proxySummaryDayDao = proxySummaryDayDao;
	}

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public DepositOrderDao getDepositOrderDao() {
		return depositOrderDao;
	}

	public void setDepositOrderDao(DepositOrderDao depositOrderDao) {
		this.depositOrderDao = depositOrderDao;
	}

	@Override
	public BaseDaoImpl<ProxySummaryDay> baseDao() {
		return proxySummaryDayDao;
	}

	@Override
	public Class<ProxySummaryDay> getClazz() {
		return ProxySummaryDay.class;
	}
}
