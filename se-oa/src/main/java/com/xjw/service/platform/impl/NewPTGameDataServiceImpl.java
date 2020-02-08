package com.xjw.service.platform.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.platform.NewPTGameDataDao;
import com.xjw.entity.po.platform.NewPtGameData;
import com.xjw.service.platform.NewPTGameDataService;

@Service
public class NewPTGameDataServiceImpl extends BaseServiceImpl<NewPtGameData> implements NewPTGameDataService {
	@Resource
	private NewPTGameDataDao newPTGameDataDao;
	public List<NewPtGameData> selectSumAll(Map<String, Object> condition) {
		return newPTGameDataDao.selectSumAll(condition);
	}

	@Override
	public BaseDaoImpl<NewPtGameData> baseDao() {
		return newPTGameDataDao;
	}

	@Override
	public Class<NewPtGameData> getClazz() {
		return NewPtGameData.class;
	}

}