package com.xjw.service.media.impl;

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
	@Override
	public BaseDaoImpl<Video> baseDao() {
		return videoDao;
	}

	@Override
	public Class<Video> getClazz() {
		return Video.class;
	}
}
