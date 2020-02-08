package com.xjw.entity.vo.order;

import java.io.Serializable;
import java.math.BigDecimal;

public class DepositOrderVo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String token;
	private Integer tradeMode;
	private String bankType;
	private BigDecimal amount;
	private Long userId;
	private String ipAddress;
	private String preferentialCode;

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getPreferentialCode() {
		return preferentialCode;
	}

	public void setPreferentialCode(String preferentialCode) {
		this.preferentialCode = preferentialCode;
	}
	
	public static void main(String[] args) {
		DepositOrderVo depositOrderVo = new DepositOrderVo();
		System.out.println(233 + "WC441lDR2e34l" + 233);
	}
}
