package com.xjw.service.platform;

import java.util.List;
import java.util.Map;

import com.xjw.base.service.BaseServcie;
import com.xjw.entity.po.platform.GameBunkoReport;

public interface GameBunkoReportService extends BaseServcie<GameBunkoReport>{
	
	public List<GameBunkoReport> selectGameBunkoReportByLogiName(Map<String, Object> params);
	
}
