package com.xjw.service.platform.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.platform.QPGameDataDao;
import com.xjw.entity.po.platform.QPGameData;
import com.xjw.entity.vo.platform.GameDataSumVo;
import com.xjw.service.platform.QPGameDataService;

@Service
public class QPGameDataServiceImpl extends BaseServiceImpl<QPGameData> implements QPGameDataService{
	@Resource
	private QPGameDataDao qpGameDataDao;

	public GameDataSumVo selectAllSum(Map<String, Object> params) {
		return qpGameDataDao.selectAllSum(params);
	}
	
	@Override
	public Class<QPGameData> getClazz() {
		return QPGameData.class;
	}

	@Override
	public QPGameDataDao baseDao() {
		return qpGameDataDao;
	}
}
