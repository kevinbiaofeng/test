package com.xjw.entity.form.sys;

import com.xjw.entity.form.BaseForm;

public class ShowPanelForm extends BaseForm {
	private static final long serialVersionUID = 1L;
	private String op;
	private String k; // 单选 r : 多选 c
	private String inputId;
	private String inputName;
	private String otherInput;

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public String getK() {
		return k;
	}

	public void setK(String k) {
		this.k = k;
	}

	public String getInputId() {
		return inputId;
	}

	public void setInputId(String inputId) {
		this.inputId = inputId;
	}

	public String getInputName() {
		return inputName;
	}

	public void setInputName(String inputName) {
		this.inputName = inputName;
	}

	public String getOtherInput() {
		return otherInput;
	}

	public void setOtherInput(String otherInput) {
		this.otherInput = otherInput;
	}

}
