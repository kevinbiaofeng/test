package com.xjw.common.result;

import java.io.Serializable;

public abstract class BaseResult implements Serializable {
	private static final long serialVersionUID = -3133998875031611171L;
	
	/** 是否成功 */
	private Boolean success;
	/** 输出编码		格式(系统:模块:代码码 )*/
	private String code;
	/** 输出信息 */
	private String msg;
	
	public BaseResult(){
	}
	
	public <T extends BaseResult> T withSuccess() {
		return this.withSuccess(null, null);
	}
	
	public <T extends BaseResult> T withSuccess(String msg) {
		return this.withSuccess(null, msg);
	}

	@SuppressWarnings("unchecked")
	public <T extends BaseResult> T withSuccess(String code, String msg) {
		this.success = Boolean.TRUE;
		this.code = code;
		this.msg = msg;
		return (T) this;
	}
	
	public <T extends BaseResult> T withError() {
		return this.withError(null, null);
	}
	
	public <T extends BaseResult> T withError(String msg) {
		return this.withError(null, msg);
	}
	
	@SuppressWarnings("unchecked")
	public <T extends BaseResult> T withError(String code, String msg) {
		this.success = Boolean.FALSE;
		this.code = code;
		this.msg = msg;
		return (T) this;
	}
	
	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
