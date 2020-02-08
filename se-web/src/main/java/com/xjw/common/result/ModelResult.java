package com.xjw.common.result;

import java.io.Serializable;

/**
 * RPC调用返回值
 */
public class ModelResult<T> extends BaseResult implements Serializable {
	private static final long serialVersionUID = 5476527403913604854L;

	private T model;
	
	public ModelResult() {
		this(null);
	}

	public ModelResult(T model) {
		super();
		this.model = model;
	}
	
	public T getModel() {
		return model;
	}

	public void setModel(T model) {
		this.model = model;
	}
}
