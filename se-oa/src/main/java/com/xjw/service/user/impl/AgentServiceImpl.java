package com.xjw.service.user.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.user.AgentDao;
import com.xjw.entity.po.sys.User;
import com.xjw.entity.po.user.Agent;
import com.xjw.kzenum.sys.UserTypeAllEnum;
import com.xjw.service.sys.UserService;
import com.xjw.service.user.AgentService;
import com.xjw.utility.MD5Util;
import com.xjw.utility.SHAUtil;

@Service
public class AgentServiceImpl extends BaseServiceImpl<Agent> implements AgentService {
	@Resource
	private AgentDao agentDao;
	@Resource
	private UserService userService;

	public void saveAgent(User user, Agent agent) throws Exception{
		user.setType(Integer.valueOf(UserTypeAllEnum.DL.getCode()));
		user.setPwd(MD5Util.md5Encode(user.getPwd()));
		user = userService.save(user);
		
		agent.setUserId(user.getId());
		try {
			agent.setAgentLink(SHAUtil.shaEncode(agent.getPromotionCode()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.save(agent);
	}

	public void updateAgent(User user, Agent agent) throws Exception{
		User oldUser = userService.selectById(user.getId());
		if(!oldUser.getPwd().equals(user.getPwd())){
			user.setPwd(MD5Util.md5Encode(user.getPwd()));
		}
		
		user.setType(Integer.valueOf(UserTypeAllEnum.DL.getCode()));
		userService.update(user);
		
		try {
			agent.setAgentLink(SHAUtil.shaEncode(agent.getPromotionCode()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.update(agent);
	}
	
	public Agent checkPromotionCode(String promotionCode){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("promotionCode", promotionCode);
		return this.selectOne(param);
	}
	
	public Agent checkPromotionUrl(String promotionUrl){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("promotionUrl", promotionUrl);
		return this.selectOne(param);
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
