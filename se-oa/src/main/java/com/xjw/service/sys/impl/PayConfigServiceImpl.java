package com.xjw.service.sys.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.sys.PayConfigDao;
import com.xjw.entity.po.sys.PayConfig;
import com.xjw.service.sys.PayConfigService;

@Service
public class PayConfigServiceImpl extends BaseServiceImpl<PayConfig> implements PayConfigService {

	@Autowired
	private PayConfigDao payConfigDao;
	
	@Override
	public BaseDaoImpl<PayConfig> baseDao() {
		return payConfigDao;
	}

	@Override
	public Class<PayConfig> getClazz() {
		return PayConfig.class;
	}
}
