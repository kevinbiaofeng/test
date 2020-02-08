package com.xjw.service.platform.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.platform.NewPtGameDataDao;
import com.xjw.entity.po.platform.NewPtGameData;
import com.xjw.entity.vo.platform.GameDataSumVo;
import com.xjw.service.platform.NewPtGameDataService;

@Service
public class NewPtGameDataServiceImpl extends BaseServiceImpl<NewPtGameData> implements NewPtGameDataService {

	@Autowired
	private NewPtGameDataDao newPtGameDataDao;
	
	public GameDataSumVo selectAllSum(Map<String, Object> params) {
		return newPtGameDataDao.selectAllSum(params);
	}
	
	@Override
	public BaseDaoImpl<NewPtGameData> baseDao() {
		return newPtGameDataDao;
	}

	@Override
	public Class<NewPtGameData> getClazz() {
		return NewPtGameData.class;
	}


}
