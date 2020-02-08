package com.xjw.entity.po.order;

import java.math.BigDecimal;

import com.xjw.base.entity.BasePo;

public class DepositOrder extends BasePo {
	private static final long serialVersionUID = 1L;
	private Long userId;
	private String orderNo;
	private Integer fromBankType;
	private String fromBankAccount;
	private String fromBankCard;
	private Integer tradeMode;
	private BigDecimal tradeAmount;
	private Long toBankId;
	private String toBankType;
	private String toBankCard;
	private String toBankAccount;
	private String remark;
	private String preferentialCode;
	private String loginName;
	private String ipAddress;
	private Integer operationType;
	private String updateUserName;
	private BigDecimal countTradeAmount;//用于页面统计计算用
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getFromBankType() {
		return fromBankType;
	}

	public void setFromBankType(Integer fromBankType) {
		this.fromBankType = fromBankType;
	}

	public String getFromBankAccount() {
		return fromBankAccount;
	}

	public void setFromBankAccount(String fromBankAccount) {
		this.fromBankAccount = fromBankAccount;
	}

	public String getFromBankCard() {
		return fromBankCard;
	}

	public void setFromBankCard(String fromBankCard) {
		this.fromBankCard = fromBankCard;
	}

	public Integer getTradeMode() {
		return tradeMode;
	}

	public void setTradeMode(Integer tradeMode) {
		this.tradeMode = tradeMode;
	}

	public BigDecimal getTradeAmount() {
		return tradeAmount;
	}

	public void setTradeAmount(BigDecimal tradeAmount) {
		this.tradeAmount = tradeAmount;
	}

	public Long getToBankId() {
		return toBankId;
	}

	public void setToBankId(Long toBankId) {
		this.toBankId = toBankId;
	}

	public String getToBankType() {
		return toBankType;
	}

	public void setToBankType(String toBankType) {
		this.toBankType = toBankType;
	}

	public String getToBankCard() {
		return toBankCard;
	}

	public void setToBankCard(String toBankCard) {
		this.toBankCard = toBankCard;
	}

	public String getToBankAccount() {
		return toBankAccount;
	}

	public void setToBankAccount(String toBankAccount) {
		this.toBankAccount = toBankAccount;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getPreferentialCode() {
		return preferentialCode;
	}

	public void setPreferentialCode(String preferentialCode) {
		this.preferentialCode = preferentialCode;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getUpdateUserName() {
		return updateUserName;
	}

	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Integer getOperationType() {
		return operationType;
	}

	public void setOperationType(Integer operationType) {
		this.operationType = operationType;
	}

	public BigDecimal getCountTradeAmount() {
		return countTradeAmount;
	}

	public void setCountTradeAmount(BigDecimal countTradeAmount) {
		this.countTradeAmount = countTradeAmount;
	}

}
