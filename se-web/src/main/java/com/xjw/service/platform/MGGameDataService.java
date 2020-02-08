package com.xjw.service.platform;

import java.util.Map;

import com.xjw.base.service.BaseServcie;
import com.xjw.entity.po.platform.MGGameData;
import com.xjw.entity.vo.platform.GameDataSumVo;

public interface MGGameDataService extends BaseServcie<MGGameData>{
	
	public GameDataSumVo selectAllSum(Map<String, Object> params);
}
