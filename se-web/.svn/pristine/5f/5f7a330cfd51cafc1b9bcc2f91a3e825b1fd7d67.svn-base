package com.xjw.dao.media;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.entity.po.media.Video;
import com.xjw.utility.BizException;
import com.xjw.utility.ClassUtil;

@Repository
public class VideoDao extends BaseDaoImpl<Video> {

	public void updateClickCount(String code, Integer clickCount) throws BizException {
		Map<String, Object> params = new HashMap<>();
		params.put("code", code);
		params.put("clickCount", clickCount);
		super.update(ClassUtil.getMapId(Video.class, new Throwable()), params);
	}
	
	public void updateFavoriteCount(String code, Integer favoriteCount) throws BizException {
		Map<String, Object> params = new HashMap<>();
		params.put("code", code);
		params.put("favoriteCount", favoriteCount);
		super.update(ClassUtil.getMapId(Video.class, new Throwable()), params);
	}
	
	public void updateStatus(String code, Date updateTime) throws BizException {
		Map<String, Object> params = new HashMap<>();
		params.put("code", code);
		params.put("updateTime", updateTime);
		super.update(ClassUtil.getMapId(Video.class, new Throwable()), params);
	}
}
