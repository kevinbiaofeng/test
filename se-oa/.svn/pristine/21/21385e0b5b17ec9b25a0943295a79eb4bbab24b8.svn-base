package com.xjw.service.sys.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.sys.UserLoginLogDao;
import com.xjw.entity.po.sys.User;
import com.xjw.entity.po.sys.UserLoginLog;
import com.xjw.service.sys.UserLoginLogService;
import com.xjw.service.sys.UserService;
import com.xjw.utility.BizException;

@Service
public class UserLoginLogServiceImpl extends BaseServiceImpl<UserLoginLog> implements UserLoginLogService{
	
	@Resource
	private UserLoginLogDao userLoginLogDao;
	@Resource
	private UserService userService;

	public void saveUserLoginLog(User user, String ip, Integer netWorkType) throws BizException {
		user.setId(user.getId());
		user.setLoginTime(new Date());
		userService.update(user);
		UserLoginLog userLoginLog = new UserLoginLog();
		userLoginLog.setLoginName(user.getLoginName());
		userLoginLog.setUserId(user.getId());
		userLoginLog.setIpAddress(ip);
		userLoginLog.setNetworkType(netWorkType);
		this.save(userLoginLog);
	}

	public List<UserLoginLog> getGroupData(Map<String, Object> params) throws BizException {
		return userLoginLogDao.getGroupData(params);
	}

	public List<UserLoginLog> getByIp3(Map<String, Object> params) {
		return userLoginLogDao.getByIp3(params);
	}
	
	public List<String> getIpList(Map<String, Object> params) {
		return userLoginLogDao.getIpList(params);
	}

	@Override
	public Class<UserLoginLog> getClazz() {
		return UserLoginLog.class;
	}

	@Override
	public BaseDaoImpl<UserLoginLog> baseDao() {
		return userLoginLogDao;
	}
}
