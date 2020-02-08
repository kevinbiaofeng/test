package com.xjw.service.platform.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.platform.NewMgGameDataDao;
import com.xjw.entity.po.platform.NewMgGameData;
import com.xjw.entity.vo.platform.GameDataSumVo;
import com.xjw.service.platform.NewMgGameDataService;

@Service
public class NewMgGameDataServiceImpl extends BaseServiceImpl<NewMgGameData> implements NewMgGameDataService {

	@Autowired
	private NewMgGameDataDao dao;
	
	public GameDataSumVo selectAllSum(Map<String, Object> params) {
		return dao.selectAllSum(params);
	}
	
	@Override
	public BaseDaoImpl<NewMgGameData> baseDao() {
		return dao;
	}

	@Override
	public Class<NewMgGameData> getClazz() {
		return NewMgGameData.class;
	}


}
