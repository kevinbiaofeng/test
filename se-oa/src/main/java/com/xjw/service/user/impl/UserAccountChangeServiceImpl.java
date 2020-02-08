package com.xjw.service.user.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.user.AccountIntegralDao;
import com.xjw.entity.po.user.AccountIntegral;
import com.xjw.service.user.UserAccountChangeService;

@Service
public class UserAccountChangeServiceImpl extends BaseServiceImpl<AccountIntegral> implements UserAccountChangeService {
    @Resource
    private AccountIntegralDao accountIntegralDao;

    @Override
    public Class<AccountIntegral> getClazz() {
        return AccountIntegral.class;
    }

    @Override
    public BaseDaoImpl<AccountIntegral> baseDao() {
        return accountIntegralDao;
    }
}
