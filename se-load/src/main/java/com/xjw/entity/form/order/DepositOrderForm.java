package com.xjw.entity.form.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class DepositOrderForm implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer tradeMode;
	private String bankType;
	private BigDecimal amount;
	private Long createTime;
	private String ip;

	public Integer getTradeMode() {
		return tradeMode;
	}

	public void setTradeMode(Integer tradeMode) {
		this.tradeMode = tradeMode;
	}

	public String getBankType() {
		return bankType;
	}

	public void setBankType(String bankType) {
		this.bankType = bankType;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

}
