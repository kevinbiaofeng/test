package com.xjw.service.platform;

import java.util.Map;

import com.xjw.base.service.BaseServcie;
import com.xjw.entity.po.platform.QPGameData;
import com.xjw.entity.vo.platform.GameDataSumVo;
/**
 * 包含棋牌电子游戏
 */
public interface QPGameDataService extends BaseServcie<QPGameData>{
	
	public GameDataSumVo selectAllSum(Map<String, Object> params);
}