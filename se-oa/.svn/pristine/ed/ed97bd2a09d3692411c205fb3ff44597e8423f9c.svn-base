package com.xjw.service.activity.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.activity.UserRedBonusDao;
import com.xjw.entity.po.activity.UserRedBonus;
import com.xjw.service.activity.UserRedBonusService;

@Service
public class UserRedBonusServiceImpl extends BaseServiceImpl<UserRedBonus> implements UserRedBonusService {
  @Resource
  private UserRedBonusDao userRedBonusDao;
  
  
  @Override
  public Class<UserRedBonus> getClazz() {
    return UserRedBonus.class;
  }

  @Override
  public BaseDaoImpl<UserRedBonus> baseDao() {
    return userRedBonusDao;
  }
}
