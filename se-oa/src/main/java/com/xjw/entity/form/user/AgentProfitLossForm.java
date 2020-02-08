package com.xjw.entity.form.user;

import com.xjw.entity.form.BaseForm;

public class AgentProfitLossForm extends BaseForm {
	private static final long serialVersionUID = 1L;
	private String id;
	private String loginName;
	private String beginTime;
	private String endTime;

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
