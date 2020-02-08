package com.xjw.service.user.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.user.AgentProfitLossDao;
import com.xjw.entity.po.user.AgentProfitLoss;
import com.xjw.service.user.AgentProfitLossService;

@Service
public class AgentProfitLossServiceImpl extends BaseServiceImpl<AgentProfitLoss> implements AgentProfitLossService {
	@Resource
	private AgentProfitLossDao agentProfitLossDao;

	
	@Override
	public Class<AgentProfitLoss> getClazz() {
		return AgentProfitLoss.class;
	}

	@Override
	public BaseDaoImpl<AgentProfitLoss> baseDao() {
		return agentProfitLossDao;
	}

}
