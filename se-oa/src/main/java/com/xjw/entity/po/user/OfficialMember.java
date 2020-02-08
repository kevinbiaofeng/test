package com.xjw.entity.po.user;

import java.math.BigDecimal;

import com.xjw.base.entity.BasePo;

public class OfficialMember extends BasePo{
	private static final long serialVersionUID = 1L;
	private String userId;
	private String loginName;
	private BigDecimal depositAmout;
	private int depositCount;
	private BigDecimal withdrawalAmout;
	private int withdrawalCount;
	private BigDecimal hlmoney;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public BigDecimal getDepositAmout() {
		return depositAmout;
	}
	public void setDepositAmout(BigDecimal depositAmout) {
		this.depositAmout = depositAmout;
	}
	public int getDepositCount() {
		return depositCount;
	}
	public void setDepositCount(int depositCount) {
		this.depositCount = depositCount;
	}
	public BigDecimal getWithdrawalAmout() {
		return withdrawalAmout;
	}
	public void setWithdrawalAmout(BigDecimal withdrawalAmout) {
		this.withdrawalAmout = withdrawalAmout;
	}
	public int getWithdrawalCount() {
		return withdrawalCount;
	}
	public void setWithdrawalCount(int withdrawalCount) {
		this.withdrawalCount = withdrawalCount;
	}
	public BigDecimal getHlmoney() {
		return hlmoney;
	}
	public void setHlmoney(BigDecimal hlmoney) {
		this.hlmoney = hlmoney;
	}
	
}