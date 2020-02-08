package com.xjw.service.platform.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.platform.AGGameDataDao;
import com.xjw.entity.po.platform.AGGameData;
import com.xjw.entity.vo.platform.GameDataSumVo;
import com.xjw.service.platform.AGGameDataService;

@Service
public class AGGameDataServiceImpl extends BaseServiceImpl<AGGameData> implements AGGameDataService{
	@Resource
	private AGGameDataDao agGameDataDao;

	public GameDataSumVo selectAllSum(Map<String, Object> params) {
		return agGameDataDao.selectAllSum(params);
	}

	@Override
	public Class<AGGameData> getClazz() {
		return AGGameData.class;
	}

	@Override
	public BaseDaoImpl<AGGameData> baseDao() {
		return agGameDataDao;
	}

}
