package com.xjw.service.platform.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.platform.NewMgGameDataDao;
import com.xjw.entity.po.platform.NewMgGameData;
import com.xjw.service.platform.NewMGGameDataService;

@Service
public class NewMGGameDataServiceImpl extends BaseServiceImpl<NewMgGameData> implements NewMGGameDataService {
	@Resource
	private NewMgGameDataDao newMgGameDataDao;
	public List<NewMgGameData> selectSumAll(Map<String, Object> condition) {
		return newMgGameDataDao.selectSumAll(condition);
	}

	@Override
	public BaseDaoImpl<NewMgGameData> baseDao() {
		return newMgGameDataDao;
	}

	@Override
	public Class<NewMgGameData> getClazz() {
		return NewMgGameData.class;
	}

}
