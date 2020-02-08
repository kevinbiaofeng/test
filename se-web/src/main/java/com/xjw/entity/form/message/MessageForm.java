package com.xjw.entity.form.message;

import java.io.Serializable;

public class MessageForm implements Serializable {
	
	private static final long serialVersionUID = -8068672577876993797L;
	
	private Integer readStatus;

	public Integer getReadStatus() {
		return readStatus;
	}

	public void setReadStatus(Integer readStatus) {
		this.readStatus = readStatus;
	}
}
