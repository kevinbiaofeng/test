package com.xjw.dao.user;

import org.springframework.stereotype.Repository;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.entity.po.user.Agent;

@Repository
public class AgentDao extends BaseDaoImpl<Agent>{
	public Agent queryByPromotionCode(String promotionCode) {
		return getSqlSession().selectOne("Agent.queryByPromotionCode", promotionCode);
	}
	
	public Agent queryByPromotionUrl(String promotionUrl) {
		return getSqlSession().selectOne("Agent.queryByPromotionUrl", promotionUrl);
	}
}
