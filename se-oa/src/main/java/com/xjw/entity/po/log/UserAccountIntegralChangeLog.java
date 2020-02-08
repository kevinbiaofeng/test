package com.xjw.entity.po.log;

import java.math.BigDecimal;

import com.xjw.base.entity.BasePo;
import com.xjw.kzenum.user.MemberMoneyChangeTypeEnum;

public class UserAccountIntegralChangeLog extends BasePo {

	private static final long serialVersionUID = 1L;
	private Long userId;
	private BigDecimal money;
	private BigDecimal totalMoney;
	private BigDecimal integral;
	private BigDecimal redProfit;
	private String tableName;
	private Long businessTableId;
	private String orderNo;
	private String ipAddress;
	private String remark;
	private Integer type;
	private Integer gameType;
	private BigDecimal gameBalance;
	private BigDecimal multiple;
	/** 调整类别 {@link MemberMoneyChangeTypeEnum} */
	private Integer changeType;
	/** 优惠活动ID */
	private Long actId;
	private String userName;
	private BigDecimal platformBalance;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public BigDecimal getIntegral() {
		return integral;
	}

	public void setIntegral(BigDecimal integral) {
		this.integral = integral;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public BigDecimal getRedProfit() {
		return redProfit;
	}

	public void setRedProfit(BigDecimal redProfit) {
		this.redProfit = redProfit;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Long getBusinessTableId() {
		return businessTableId;
	}

	public void setBusinessTableId(Long businessTableId) {
		this.businessTableId = businessTableId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public BigDecimal getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getGameType() {
		return gameType;
	}

	public void setGameType(Integer gameType) {
		this.gameType = gameType;
	}

	public BigDecimal getGameBalance() {
		return gameBalance;
	}

	public void setGameBalance(BigDecimal gameBalance) {
		this.gameBalance = gameBalance;
	}

	public BigDecimal getMultiple() {
		return multiple;
	}

	public void setMultiple(BigDecimal multiple) {
		this.multiple = multiple;
	}

	public Integer getChangeType() {
		return changeType;
	}

	public void setChangeType(Integer changeType) {
		this.changeType = changeType;
	}

	public Long getActId() {
		return actId;
	}

	public void setActId(Long actId) {
		this.actId = actId;
	}

	public BigDecimal getPlatformBalance() {
		return platformBalance;
	}

	public void setPlatformBalance(BigDecimal platformBalance) {
		this.platformBalance = platformBalance;
	}

}