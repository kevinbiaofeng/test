package com.xjw.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.user.AgentDao;
import com.xjw.entity.po.user.Agent;
import com.xjw.service.user.AgentService;

@Service
public class AgentServiceImpl extends BaseServiceImpl<Agent> implements AgentService{
	@Autowired
	private AgentDao agentDao;
	
	public Agent queryByPromotionCode(String promotionCode){
		return agentDao.queryByPromotionCode(promotionCode);
	}
	
	public Agent queryByPromotionUrl(String promotionUrl) {
		return agentDao.queryByPromotionUrl(promotionUrl);
	}
	
	@Override
	public Class<Agent> getClazz() {
		return Agent.class;
	}

	@Override
	public BaseDaoImpl<Agent> baseDao() {
		return agentDao;
	}
}
