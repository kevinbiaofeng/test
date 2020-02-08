package com.xjw.service.platform;

import java.util.Map;

import com.xjw.base.service.BaseServcie;
import com.xjw.entity.po.platform.PTGameData;
import com.xjw.entity.vo.platform.GameDataSumVo;

public interface PTGameDataService extends BaseServcie<PTGameData>{
	
	public GameDataSumVo selectAllSum(Map<String, Object> params);
}
