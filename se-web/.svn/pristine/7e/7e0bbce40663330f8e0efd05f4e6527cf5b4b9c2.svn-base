package com.xjw.service.media.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.media.VideoDao;
import com.xjw.entity.po.media.Video;
import com.xjw.service.media.VideoService;
import com.xjw.utility.BizException;

@Service
public class VideoServiceImpl extends BaseServiceImpl<Video> implements VideoService {

	@Autowired
	private VideoDao videoDao;
	
	@Override
	public Video selectByCode(String code) {
		if(StringUtils.isNotBlank(code)) {
			Map<String, Object> params = new HashMap<>();
			params.put("code", code);
			return super.selectOne(params);
		}
		
		return null;
	}
	
	public void updateShow() throws BizException{
		Map<String, Object> params = new HashMap<>();
		params.put("status", 2);
		Video video = this.selectOne(params);
		if(video != null){
			this.updateStatus(video.getCode(), new Date());
		}
	}

	@Override
	public void updateClickCount(String code, Integer clickCount) throws BizException {
		videoDao.updateClickCount(code, clickCount);
	}
	
	@Override
	public void updateFavoriteCount(String code, Integer favoriteCount) throws BizException {
		videoDao.updateFavoriteCount(code, favoriteCount);
	}
	
	@Override
	public void updateStatus(String code, Date updateTime) throws BizException {
		videoDao.updateStatus(code, updateTime);
	}
	
	@Override
	public BaseDaoImpl<Video> baseDao() {
		return videoDao;
	}

	@Override
	public Class<Video> getClazz() {
		return Video.class;
	}
	
	public static void main(String[] args) {
		System.out.println((int)(Math.random()*3+1));
	}
}
