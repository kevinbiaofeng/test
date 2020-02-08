package com.xjw.service.media.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.media.FavoriteDao;
import com.xjw.entity.po.media.Favorite;
import com.xjw.service.media.FavoriteService;

@Service
public class FavoriteServiceImpl extends BaseServiceImpl<Favorite> implements FavoriteService {
	
	@Override
	public Favorite queryOne(Long userId, String videoCode) {
		if(null != userId && StringUtils.isNotBlank(videoCode)) {
			Map<String, Object> params = new HashMap<>();
			params.put("userId", userId);
			params.put("videoCode", videoCode);
			List<Favorite> list = this.selectAll(params);
			if(list.size() > 0) {
				return list.get(0);
			}
		}
		
		return null;
	}

	@Autowired
	private FavoriteDao favoriteDao;
	
	@Override
	public BaseDaoImpl<Favorite> baseDao() {
		return favoriteDao;
	}

	@Override
	public Class<Favorite> getClazz() {
		return Favorite.class;
	}
}
