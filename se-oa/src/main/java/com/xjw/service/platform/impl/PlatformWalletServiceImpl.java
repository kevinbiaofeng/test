package com.xjw.service.platform.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.platform.PlatformWalletDao;
import com.xjw.entity.po.platform.PlatformWallet;
import com.xjw.service.platform.PlatformWalletService;

@Service
public class PlatformWalletServiceImpl extends BaseServiceImpl<PlatformWallet> implements PlatformWalletService{
  
	@Autowired
	private PlatformWalletDao platformWalletDao;
	
	public List<PlatformWallet> selectAllGroupByAgent(Map<String, Object> params) {
		return platformWalletDao.selectAllGroupByAgent(params);
	}
  
	public Integer deleteAll() {
		return platformWalletDao.deleteAll();
	}

	@Override
	public Class<PlatformWallet> getClazz() {
		return PlatformWallet.class;
	}

	@Override
	public BaseDaoImpl<PlatformWallet> baseDao() {
		return platformWalletDao;
	}
}
