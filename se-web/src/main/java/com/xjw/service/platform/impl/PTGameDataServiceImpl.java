package com.xjw.service.platform.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.platform.PTGameDataDao;
import com.xjw.entity.po.platform.PTGameData;
import com.xjw.entity.vo.platform.GameDataSumVo;
import com.xjw.service.platform.PTGameDataService;

@Service
public class PTGameDataServiceImpl extends BaseServiceImpl<PTGameData> implements PTGameDataService {
	@Autowired
	private PTGameDataDao ptGameDataDao;

	public GameDataSumVo selectAllSum(Map<String, Object> params) {
		return ptGameDataDao.selectAllSum(params);
	}

	@Override
	public Class<PTGameData> getClazz() {
		return PTGameData.class;
	}

	@Override
	public BaseDaoImpl<PTGameData> baseDao() {
		return ptGameDataDao;
	}

}
