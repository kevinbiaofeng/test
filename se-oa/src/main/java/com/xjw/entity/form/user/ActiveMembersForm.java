package com.xjw.entity.form.user;

import com.xjw.entity.form.BaseForm;

public class ActiveMembersForm extends BaseForm {
	private static final long serialVersionUID = 1L;
	private String loginName;//代理下的会员名称
	private String userId;//代理会员Id
	private String beginTime;
	private String endTime;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
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
	
}
