package com.xjw.service.platform.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.platform.ActiveMembersDao;
import com.xjw.entity.po.platform.ActiveMembers;
import com.xjw.service.platform.ActiveMembersService;

@Service
public class ActiveMembersServiceImpl extends BaseServiceImpl<ActiveMembers> implements ActiveMembersService {
	
	@Resource
	private ActiveMembersDao activeMembersDao;
	@Override
	public BaseDaoImpl<ActiveMembers> baseDao() {
		return activeMembersDao;
	}

	@Override
	public Class<ActiveMembers> getClazz() {
		return ActiveMembers.class;
	}

}
