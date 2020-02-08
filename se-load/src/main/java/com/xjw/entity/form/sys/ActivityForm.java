package com.xjw.entity.form.sys;

import java.io.Serializable;

public class ActivityForm implements Serializable {
	private static final long serialVersionUID = 1L;
	private String type;
	private String v;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getV() {
		return v;
	}

	public void setV(String v) {
		this.v = v;
	}

}
