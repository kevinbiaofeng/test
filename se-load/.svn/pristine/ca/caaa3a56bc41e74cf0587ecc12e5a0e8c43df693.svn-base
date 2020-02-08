package com.xjw.service.platform.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.platform.SBGameDataDao;
import com.xjw.entity.po.platform.SBGameData;
import com.xjw.entity.vo.platform.GameDataSumVo;
import com.xjw.service.platform.SBGameDataService;

@Service
public class SBGameDataServiceImpl extends BaseServiceImpl<SBGameData> implements SBGameDataService {
	@Resource
	private SBGameDataDao sbGameDataDao;

	public GameDataSumVo selectAllSum(Map<String, Object> params) {
		return sbGameDataDao.selectAllSum(params);
	}

	@Override
	public Class<SBGameData> getClazz() {
		return SBGameData.class;
	}

	@Override
	public SBGameDataDao baseDao() {
		return sbGameDataDao;
	}

}
