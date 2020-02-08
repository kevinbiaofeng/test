package com.xjw.service.log.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.BaseServcie;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.log.UserLoginLogDao;
import com.xjw.entity.po.log.UserLoginLog;
import com.xjw.entity.po.user.User;
import com.xjw.service.log.UserLoginLogService;
import com.xjw.service.user.UserService;
import com.xjw.utility.BizException;

@Service
public class UserLoginLogServiceImpl extends BaseServiceImpl<UserLoginLog> implements UserLoginLogService, BaseServcie<UserLoginLog> {
  @Resource
  private UserLoginLogDao userLoginLogDao;
  @Resource
  private UserService userService;

  public void saveUserLoginLog(User user, String ip, Integer netWorkType) throws BizException{
	  Map<String, Object> modifyParam = new HashMap<String, Object>();
	  modifyParam.put("loginTime", new Date());
	  modifyParam.put("id", user.getId());
	  userService.update(modifyParam);
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
  
  @Override
  public Class<UserLoginLog> getClazz() {
	  return UserLoginLog.class;
  }

  @Override
  public BaseDaoImpl<UserLoginLog> baseDao() {
	  return userLoginLogDao;
  }
}
