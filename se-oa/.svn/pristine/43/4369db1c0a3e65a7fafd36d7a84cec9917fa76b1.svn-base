package com.xjw.service.activity.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.activity.WithdrawLimitDao;
import com.xjw.entity.po.activity.WithdrawLimit;
import com.xjw.service.activity.WithdrawLimitService;

@Service
public class WithdrawLimitServiceImpl extends BaseServiceImpl<WithdrawLimit> implements WithdrawLimitService {
  @Resource
  private WithdrawLimitDao withdrawLimitDao;
  
  
  @Override
  public Class<WithdrawLimit> getClazz() {
    return WithdrawLimit.class;
  }

  @Override
  public BaseDaoImpl<WithdrawLimit> baseDao() {
    return withdrawLimitDao;
  }
}
