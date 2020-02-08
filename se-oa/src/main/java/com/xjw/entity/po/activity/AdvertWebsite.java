package com.xjw.entity.po.activity;

import java.util.Date;

import com.xjw.base.entity.BasePo;

public class AdvertWebsite extends BasePo {
	private static final long serialVersionUID = 1L;
	private String name;
	private Date startTime;
	private Date endTime;
	private String context;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}
}
