package com.xjw.service.platform.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.platform.GameBunkoReportDao;
import com.xjw.entity.po.platform.GameBunkoReport;
import com.xjw.entity.po.sys.User;
import com.xjw.service.platform.GameBunkoReportService;
import com.xjw.service.sys.UserService;

@Service
public class GameBunkoReportServiceImpl extends BaseServiceImpl<GameBunkoReport> implements GameBunkoReportService{
	@Autowired
	private GameBunkoReportDao gameBunkoReportDao;
	@Resource
	private UserService userService;
	
	@Override
	public BaseDaoImpl<GameBunkoReport> baseDao() {
		return gameBunkoReportDao;
	}

	@Override
	public Class<GameBunkoReport> getClazz() {
		return GameBunkoReport.class;
	}

	public List<GameBunkoReport> selectGameBunkoReportByLogiName(Map<String, Object> params) {
		User user = userService.getUserByLoginName(params.get("loginName").toString());
		if(null != user)
			params.put("userId", user.getId());
		
		List<GameBunkoReport> list = new ArrayList<GameBunkoReport>();
		List<GameBunkoReport> mg = gameBunkoReportDao.selectNewMgByLogiName(params);
		List<GameBunkoReport> pt = gameBunkoReportDao.selectNewPtByLogiName(params);
		List<GameBunkoReport> xin = gameBunkoReportDao.selectXinByLogiName(params);
		if(null != mg )
			list.addAll(mg);
		if(null != pt)
			list.addAll(pt);
		if(null != xin)
			list.addAll(xin);
		
		return list;
	}
	
	

}
