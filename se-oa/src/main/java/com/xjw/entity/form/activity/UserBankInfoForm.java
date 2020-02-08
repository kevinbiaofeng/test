package com.xjw.entity.form.activity;

import com.xjw.entity.form.BaseForm;

public class UserBankInfoForm extends BaseForm {
	private static final long serialVersionUID = 1L;
	private String id;
	private String bankType;
	private String status;
	private String type;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBankType() {
		return bankType;
	}

	public void setBankType(String bankType) {
		this.bankType = bankType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
