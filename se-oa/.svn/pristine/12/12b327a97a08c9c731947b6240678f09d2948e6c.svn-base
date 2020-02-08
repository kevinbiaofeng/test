package com.xjw.service.platform.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.platform.PlatformTransferDao;
import com.xjw.entity.po.platform.PlatformTransfer;
import com.xjw.service.platform.PlatformTransferService;

@Service
public class PlatformTransferServiceImpl extends BaseServiceImpl<PlatformTransfer> implements PlatformTransferService {
    @Resource
    private PlatformTransferDao platformTransferDao;

    @Override
    public Class<PlatformTransfer> getClazz() {
        return PlatformTransfer.class;
    }

    @Override
    public BaseDaoImpl<PlatformTransfer> baseDao() {
        return platformTransferDao;
    }
}
