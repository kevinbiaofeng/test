package com.xjw.service.log.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.log.UserPlayLogDao;
import com.xjw.entity.po.log.UserPlayLog;
import com.xjw.service.log.UserPlayLogService;

@Service
public class UserPlayLogServiceImpl extends BaseServiceImpl<UserPlayLog> implements UserPlayLogService {
	

	@Autowired
	private UserPlayLogDao userPlayLogDao;
	
	@Override
	public BaseDaoImpl<UserPlayLog> baseDao() {
		return userPlayLogDao;
	}

	@Override
	public Class<UserPlayLog> getClazz() {
		return UserPlayLog.class;
	}
}
