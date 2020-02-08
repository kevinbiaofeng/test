package com.xjw.dao.log;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.entity.po.log.UserLoginLog;

@Repository
public class UserLoginLogDao extends BaseDaoImpl<UserLoginLog>{
	public List<UserLoginLog> getGroupData(Map<String, Object> params) {
		return getSqlSession().selectList("UserLoginLog.selectGroupByData", params);
	}
}
