package com.xjw.service.activity.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.activity.RebateDao;
import com.xjw.entity.po.activity.Rebate;
import com.xjw.service.activity.RebateService;

@Service
public class RebateServiceImpl extends BaseServiceImpl<Rebate> implements RebateService {
  @Resource
  private RebateDao rebateDao;
  
  
  @Override
  public Class<Rebate> getClazz() {
    return Rebate.class;
  }

  @Override
  public BaseDaoImpl<Rebate> baseDao() {
    return rebateDao;
  }
}
