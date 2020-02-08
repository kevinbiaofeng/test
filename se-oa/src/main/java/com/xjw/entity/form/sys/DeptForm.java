package com.xjw.entity.form.sys;

import com.xjw.entity.form.BaseForm;

public class DeptForm extends BaseForm {
	private static final long serialVersionUID = 1L;
	private String id;
	private String code;
	private String name;
	private String deptId;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

}
