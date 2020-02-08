package com.xjw.entity.form.order;

import java.io.Serializable;
import java.math.BigDecimal;

public class WithdrawalOrderForm implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long userBankId;
	private BigDecimal amount;
	private String remark;
	

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Long getUserBankId() {
		return userBankId;
	}

	public void setUserBankId(Long userBankId) {
		this.userBankId = userBankId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
