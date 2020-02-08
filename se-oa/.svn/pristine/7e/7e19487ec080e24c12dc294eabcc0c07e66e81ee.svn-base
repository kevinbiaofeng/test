package com.xjw.service.sys.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.sys.UserDeptRelDao;
import com.xjw.entity.po.sys.UserDeptRel;
import com.xjw.service.sys.UserDeptRelService;

@Service
public class UserDeptRelServiceImpl extends BaseServiceImpl<UserDeptRel> implements UserDeptRelService {
   @Resource
   private UserDeptRelDao userDeptRelDao;
  

  @Override
  public Class<UserDeptRel> getClazz() {
    return UserDeptRel.class;
  }

  @Override
  public BaseDaoImpl<UserDeptRel> baseDao() {
    return userDeptRelDao;
  }


  

}
