package com.xjw.dao.user;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.entity.po.user.Member;

@Repository
public class MemberDao extends BaseDaoImpl<Member>{
	
	/** 查询代理的下线用户数量  */
	public int selectCountByAgent(Map<String, Object> params){
		return super.getSqlSession().selectOne("Member.selectCountByAgent", params);
	}
	
	/** 查询代理用户信息  */
	public Member selectAgentById(Long userId){
		return super.getSqlSession().selectOne("Member.selectAgentById", userId);
	}
}
