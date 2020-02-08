package com.xjw.service.platform.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.platform.MGGameDataDao;
import com.xjw.entity.po.platform.MGGameData;
import com.xjw.entity.vo.platform.GameDataSumVo;
import com.xjw.service.platform.MGGameDataService;

@Service
public class MGGameDataServiceImpl extends BaseServiceImpl<MGGameData> implements MGGameDataService {
	@Resource
	private MGGameDataDao mgGameDataDao;

	public GameDataSumVo selectAllSum(Map<String, Object> params) {
		return mgGameDataDao.selectAllSum(params);
	}

	@Override
	public Class<MGGameData> getClazz() {
		return MGGameData.class;
	}

	@Override
	public BaseDaoImpl<MGGameData> baseDao() {
		return mgGameDataDao;
	}

}
