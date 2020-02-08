package com.xjw.dao.sys;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.entity.po.sys.UserLoginLog;

@Repository
public class UserLoginLogDao extends BaseDaoImpl<UserLoginLog>{
	public List<UserLoginLog> getGroupData(Map<String, Object> params) {
		return getSqlSession().selectList("UserLoginLog.selectGroupByData", params);
	}
	
	public List<UserLoginLog> getByIp3(Map<String, Object> params){
		return getSqlSession().selectList("UserLoginLog.selectByIp3", params);
	}
	
	public List<String> getIpList(Map<String, Object> params){
		return getSqlSession().selectList("UserLoginLog.selectIpList", params);
	}
}
