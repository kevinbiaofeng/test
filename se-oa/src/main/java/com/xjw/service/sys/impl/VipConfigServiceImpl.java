package com.xjw.service.sys.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.sys.VipConfigDao;
import com.xjw.entity.po.sys.VipConfig;
import com.xjw.service.sys.VipConfigService;

@Service
public class VipConfigServiceImpl extends BaseServiceImpl<VipConfig> implements VipConfigService{
	
	@Autowired
	private VipConfigDao vipConfigDao;
	
	@Override
	public BaseDaoImpl<VipConfig> baseDao() {
		return vipConfigDao;
	}

	@Override
	public Class<VipConfig> getClazz() {
		return VipConfig.class;
	}

}
