package com.xjw.entity.form.sys;

import java.util.Date;

import com.xjw.entity.form.BaseForm;

public class YestdayAmountLogForm extends BaseForm {
	private static final long serialVersionUID = -1456565266216899042L;

	private Date beginStatTime;
	private Date endStatTime;

	public Date getBeginStatTime() {
		return beginStatTime;
	}

	public void setBeginStatTime(Date beginStatTime) {
		this.beginStatTime = beginStatTime;
	}

	public Date getEndStatTime() {
		return endStatTime;
	}

	public void setEndStatTime(Date endStatTime) {
		this.endStatTime = endStatTime;
	}
}
