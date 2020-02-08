package com.xjw.service.activity.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.activity.AdvertWebsiteDao;
import com.xjw.entity.po.activity.AdvertWebsite;
import com.xjw.service.activity.AdvertWebsiteService;

@Service
public class AdvertWebsiteServiceImpl extends BaseServiceImpl<AdvertWebsite> implements AdvertWebsiteService {
  @Resource
  private AdvertWebsiteDao advertWebsiteDao;
  
  @Override
  public Class<AdvertWebsite> getClazz() {
    return AdvertWebsite.class;
  }

  @Override
  public BaseDaoImpl<AdvertWebsite> baseDao() {
    return advertWebsiteDao;
  }
}
