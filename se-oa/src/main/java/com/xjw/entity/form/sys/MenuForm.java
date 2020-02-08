package com.xjw.entity.form.sys;

import com.xjw.entity.form.BaseForm;

public class MenuForm extends BaseForm {
	private static final long serialVersionUID = 1L;
	private String id;
	private String code;
	private String ids;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

}
