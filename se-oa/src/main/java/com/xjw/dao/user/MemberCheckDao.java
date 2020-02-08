package com.xjw.dao.user;

import org.springframework.stereotype.Repository;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.entity.po.user.MemberCheck;

@Repository
public class MemberCheckDao extends BaseDaoImpl<MemberCheck>{
	public MemberCheck queryByUserId(Long userId){
		return super.getSqlSession().selectOne("MemberCheck.queryByUserId", userId);
	}

}
