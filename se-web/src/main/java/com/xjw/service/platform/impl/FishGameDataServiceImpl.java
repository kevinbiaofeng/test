package com.xjw.service.platform.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.platform.FishGameDataDao;
import com.xjw.entity.po.platform.FishGameData;
import com.xjw.entity.vo.platform.GameDataSumVo;
import com.xjw.service.platform.FishGameDataService;

@Service
public class FishGameDataServiceImpl extends BaseServiceImpl<FishGameData> implements FishGameDataService {
	@Resource
	private FishGameDataDao fishGameDataDao;

	public GameDataSumVo selectAllSum(Map<String, Object> params) {
		return fishGameDataDao.selectAllSum(params);
	}

	@Override
	public Class<FishGameData> getClazz() {
		return FishGameData.class;
	}

	@Override
	public FishGameDataDao baseDao() {
		return fishGameDataDao;
	}
}
