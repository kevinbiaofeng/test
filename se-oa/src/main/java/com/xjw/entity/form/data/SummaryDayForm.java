package com.xjw.entity.form.data;

import java.util.List;

import com.xjw.entity.form.BaseForm;

public class SummaryDayForm extends BaseForm {
	private static final long serialVersionUID = -5274656693930161661L;

	private String beginTime;
	private String endTime;
	private String userId;

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
