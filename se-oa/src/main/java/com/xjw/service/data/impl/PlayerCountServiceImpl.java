package com.xjw.service.data.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.data.PlayerCountDao;
import com.xjw.entity.po.data.PlayerCount;
import com.xjw.service.data.PlayerCountService;

@Service
public class PlayerCountServiceImpl extends BaseServiceImpl<PlayerCount> implements PlayerCountService{
	
	@Resource
	private PlayerCountDao playerCountDao;
	
	@Override
	public BaseDaoImpl<PlayerCount> baseDao() {
		return playerCountDao;
	}

	@Override
	public Class<PlayerCount> getClazz() {
		return PlayerCount.class;
	}
	
	public List<Long>  getUserIdList(Map<String, Object> params){
		List<Long> userIdListAll = new ArrayList<Long>();
		
		List<Long> userIdAggj = playerCountDao.selectUserIdByAggj(params);
		if(null != userIdAggj && userIdAggj.size() > 0){
			userIdListAll.addAll(userIdAggj);
		}
		
		List<Long> userIdAgjs = playerCountDao.selectUserIdByAgjs(params);
		if(null != userIdAgjs && userIdAgjs.size() > 0){
			userIdListAll.addAll(userIdAgjs);
		}
		
		List<Long> userIdPt = playerCountDao.selectUserIdByPt(params);
		if(null != userIdPt && userIdPt.size() > 0){
			userIdListAll.addAll(userIdPt);
		}
		
		List<Long> userIdMg = playerCountDao.selectUserIdByMg(params);
		if(null != userIdMg && userIdMg.size() > 0){
			userIdListAll.addAll(userIdMg);
		}
		
		List<Long> userIdXin = playerCountDao.selectUserIdByXin(params);
		if(null != userIdXin && userIdXin.size() > 0){
			userIdListAll.addAll(userIdXin);
		}
		
		List<Long> userIdFish = playerCountDao.selectUserIdByFish(params);
		if(null != userIdFish && userIdFish.size() > 0){
			userIdListAll.addAll(userIdFish);
		}
		
		List<Long> userIdSb = playerCountDao.selectUserIdBySb(params);
		if(null != userIdSb && userIdSb.size() > 0){
			userIdListAll.addAll(userIdSb);
		}
		
		List<Long> userIdQp = playerCountDao.selectUserIdByQp(params);
		if(null != userIdQp && userIdQp.size() > 0){
			userIdListAll.addAll(userIdQp);
		}
		
		List<Long> userIdTtg = playerCountDao.selectUserIdByTtg(params);
		if(null != userIdTtg && userIdTtg.size() > 0){
			userIdListAll.addAll(userIdTtg);
		}
		
		List<Long> userIdEndo = playerCountDao.selectUserIdByEndo(params);
		if(null != userIdEndo && userIdEndo.size() > 0){
			userIdListAll.addAll(userIdEndo);
		}
		
		List<Long> userIdNewPt = playerCountDao.selectUserIdByNewPt(params);
		if(null != userIdNewPt && userIdNewPt.size() > 0){
			userIdListAll.addAll(userIdNewPt);
		}
		
		List<Long> userIdNewMg = playerCountDao.selectUserIdByNewMg(params);
		if(null != userIdNewMg && userIdNewMg.size() > 0){
			userIdListAll.addAll(userIdNewMg);
		}
		
		return userIdListAll;
	}
	

}
