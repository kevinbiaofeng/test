package com.xjw.entity.po.log;

import com.xjw.base.entity.BasePo;

/**
 * 视频收藏 
 */
public class UserPlayLog extends BasePo {
	private static final long serialVersionUID = -1409956443200408748L;
	
	/** 用户ID */
	private Long userId;
	/** 视频编号 */
	private String videoCode;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getVideoCode() {
		return videoCode;
	}

	public void setVideoCode(String videoCode) {
		this.videoCode = videoCode;
	}
}
