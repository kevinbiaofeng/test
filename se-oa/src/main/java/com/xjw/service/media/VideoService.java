package com.xjw.service.media;

import com.xjw.base.service.BaseServcie;
import com.xjw.entity.po.media.Video;

public interface VideoService extends BaseServcie<Video> {
	
	public Video selectByCode(String code);

}
