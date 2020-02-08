package com.xjw.entity.po.sys;

import com.xjw.base.entity.BasePo;

public class Role extends BasePo {

	private static final long serialVersionUID = 1L;

	private String name;
	private String code;
	private String remark;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}


}
