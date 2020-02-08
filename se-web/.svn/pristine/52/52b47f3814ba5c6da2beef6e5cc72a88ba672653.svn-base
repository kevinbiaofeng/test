package com.xjw.service.media;

import java.util.Date;

import com.xjw.base.service.BaseServcie;
import com.xjw.entity.po.media.Video;
import com.xjw.utility.BizException;

public interface VideoService extends BaseServcie<Video> {
	
	public Video selectByCode(String code);

	public void updateClickCount(String code, Integer clickCount) throws BizException;
 	
	public void updateFavoriteCount(String code, Integer favoriteCount) throws BizException;
	
	/**
	 * 修改状态为显示
	 */
	public void updateShow() throws BizException;
	
	public void updateStatus(String code, Date updateTime) throws BizException;
}
