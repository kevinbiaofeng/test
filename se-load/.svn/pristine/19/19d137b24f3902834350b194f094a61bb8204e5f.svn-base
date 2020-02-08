package com.xjw.service.sys.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.BaseServcie;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.sys.AdvertWebsiteDao;
import com.xjw.entity.po.sys.AdvertWebsite;
import com.xjw.service.sys.AdvertWebsiteService;

@Service
public class AdvertWebsiteServiceImpl extends BaseServiceImpl<AdvertWebsite> implements AdvertWebsiteService, BaseServcie<AdvertWebsite> {
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
