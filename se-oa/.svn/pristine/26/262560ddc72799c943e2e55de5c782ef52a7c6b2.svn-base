package com.xjw.service.log.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.log.UserOperationLogDao;
import com.xjw.entity.po.log.UserOperationLog;
import com.xjw.service.log.UserOperationLogService;

@Service
public class UserOperationLogServiceImpl extends BaseServiceImpl<UserOperationLog> implements UserOperationLogService {
  @Resource
  private UserOperationLogDao userOperationLogDao;

  @Override
  public Class<UserOperationLog> getClazz() {
    return UserOperationLog.class;
  }

  @Override
  public BaseDaoImpl<UserOperationLog> baseDao() {
    return userOperationLogDao;
  }
}
