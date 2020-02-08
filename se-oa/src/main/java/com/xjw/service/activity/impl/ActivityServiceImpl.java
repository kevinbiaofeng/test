package com.xjw.service.activity.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.activity.ActivityDao;
import com.xjw.entity.po.activity.Activity;
import com.xjw.service.activity.ActivityService;

@Service
public class ActivityServiceImpl extends BaseServiceImpl<Activity> implements ActivityService {
  @Resource
  private ActivityDao activityDao;
  
  
  @Override
  public Class<Activity> getClazz() {
    return Activity.class;
  }

  @Override
  public BaseDaoImpl<Activity> baseDao() {
    return activityDao;
  }
}
