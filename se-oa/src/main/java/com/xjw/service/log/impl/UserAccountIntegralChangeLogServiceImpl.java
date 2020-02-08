package com.xjw.service.log.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.log.UserAccountIntegralChangeLogDao;
import com.xjw.entity.po.log.UserAccountIntegralChangeLog;
import com.xjw.service.log.UserAccountIntegralChangeLogService;

@Service
public class UserAccountIntegralChangeLogServiceImpl extends BaseServiceImpl<UserAccountIntegralChangeLog> implements UserAccountIntegralChangeLogService {
  @Resource
  private UserAccountIntegralChangeLogDao userAccountIntegralChangeLogDao;

  @Override
  public Class<UserAccountIntegralChangeLog> getClazz() {
    return UserAccountIntegralChangeLog.class;
  }

  @Override
  public BaseDaoImpl<UserAccountIntegralChangeLog> baseDao() {
    return userAccountIntegralChangeLogDao;
  }
}
