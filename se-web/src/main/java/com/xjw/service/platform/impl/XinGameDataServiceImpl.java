package com.xjw.service.platform.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.platform.XinGameDataDao;
import com.xjw.entity.po.platform.XinGameData;
import com.xjw.entity.vo.platform.GameDataSumVo;
import com.xjw.service.platform.XinGameDataService;

@Service
public class XinGameDataServiceImpl extends BaseServiceImpl<XinGameData> implements XinGameDataService {
	@Resource
	private XinGameDataDao xinGameDataDao;

	public GameDataSumVo selectAllSum(Map<String, Object> params) {
		return xinGameDataDao.selectAllSum(params);
	}

	@Override
	public Class<XinGameData> getClazz() {
		return XinGameData.class;
	}

	@Override
	public BaseDaoImpl<XinGameData> baseDao() {
		return xinGameDataDao;
	}

}
