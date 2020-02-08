package com.xjw.entity.form.sys;

import java.io.Serializable;

public class GamesForm implements Serializable {
	private static final long serialVersionUID = 1L;
	private String gameType;
	private String code;
	private String actype;

	public String getGameType() {
		return gameType;
	}

	public void setGameType(String gameType) {
		this.gameType = gameType;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getActype() {
		return actype;
	}

	public void setActype(String actype) {
		this.actype = actype;
	}

}
