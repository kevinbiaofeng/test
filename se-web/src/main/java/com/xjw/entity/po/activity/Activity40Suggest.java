package com.xjw.entity.po.activity;

import com.xjw.base.entity.BasePo;

public class Activity40Suggest extends BasePo {
	private static final long serialVersionUID = -3459014164145951510L;
	
	private Long userId;
	private Integer type;
	private String content;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
