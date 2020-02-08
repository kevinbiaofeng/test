package com.xjw.service.platform.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.platform.PlatformGameDao;
import com.xjw.entity.po.platform.PlatformGame;
import com.xjw.service.platform.PlatformGameService;

@Service
public class PlatformGameServiceImpl extends BaseServiceImpl<PlatformGame> implements PlatformGameService {

    @Autowired
    private PlatformGameDao platformGameDao;
    
    @Override
    public BaseDaoImpl<PlatformGame> baseDao() {
        return platformGameDao;
    }

    @Override
    public Class<PlatformGame> getClazz() {
        return PlatformGame.class;
    }

}
