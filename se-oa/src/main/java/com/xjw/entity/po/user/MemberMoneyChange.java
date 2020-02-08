package com.xjw.entity.po.user;

import java.math.BigDecimal;
import java.util.Date;

import com.xjw.base.entity.BasePo;
import com.xjw.kzenum.user.MemberMoneyChangeTypeEnum;

public class MemberMoneyChange extends BasePo {

	private static final long serialVersionUID = 1L;
	private Long userId;
	private BigDecimal money;
	private BigDecimal integral;
	private BigDecimal multiple;
	private String depositOrderNo;
	private String withdrawalOrderNo;
	/** 调整类别 {@link MemberMoneyChangeTypeEnum} */
	private Integer changeType;
	/** 优惠活动ID */
	private Long actId;
	private String remark;
	// 页面显示项
	private String userName;
	private String createUserName;
	private Integer platformType;
	private Date startTime;
	private Date endTime;
	private Integer actType;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public BigDecimal getIntegral() {
		return integral;
	}

	public void setIntegral(BigDecimal integral) {
		this.integral = integral;
	}

	public BigDecimal getMultiple() {
		return multiple;
	}

	public void setMultiple(BigDecimal multiple) {
		this.multiple = multiple;
	}

	public String getDepositOrderNo() {
		return depositOrderNo;
	}

	public void setDepositOrderNo(String depositOrderNo) {
		this.depositOrderNo = depositOrderNo;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getPlatformType() {
		return platformType;
	}

	public void setPlatformType(Integer platformType) {
		this.platformType = platformType;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getActType() {
		return actType;
	}

	public void setActType(Integer actType) {
		this.actType = actType;
	}

	public String getWithdrawalOrderNo() {
		return withdrawalOrderNo;
	}

	public void setWithdrawalOrderNo(String withdrawalOrderNo) {
		this.withdrawalOrderNo = withdrawalOrderNo;
	}

}