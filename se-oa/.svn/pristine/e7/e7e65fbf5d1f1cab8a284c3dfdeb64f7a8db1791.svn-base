package com.xjw.entity.vo.user;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

import com.xjw.utility.DateUtil;
import com.xjw.utility.DateUtil.IntevalType;

public class MemberAmountVo implements Serializable {
	private static final long serialVersionUID = 7350216343666703095L;
	
	/** 会员ID */
	private Long userId;
	/** 会员账号 */
	private String loginName;
	/** 会员注册时间 */
	private Date registerTime;
	/** 会员注册天数*/
	private Long registerDays; 
	
	/** 存款金额 */
	private BigDecimal depositAmount;
	/** 取款金额 */
	private BigDecimal withdrawAmount;
	/** 奖金金额 */
	 private BigDecimal awardAmount;
	/** 返水金额 */
	private BigDecimal rakeAmount;

	public Long getUserId() {
		return userId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	/**
	 * 设置注册时间的同时计算已注册天数 
	 */
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
		this.registerDays = DateUtil.getInterval(DateUtils.toCalendar(registerTime), IntevalType.DAY);
	}

	public Long getRegisterDays() {
		return registerDays;
	}

	public void setRegisterDays(Long registerDays) {
		this.registerDays = registerDays;
	}

	public BigDecimal getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(BigDecimal depositAmount) {
		this.depositAmount = depositAmount;
	}

	public BigDecimal getWithdrawAmount() {
		return withdrawAmount;
	}

	public void setWithdrawAmount(BigDecimal withdrawAmount) {
		this.withdrawAmount = withdrawAmount;
	}

	public BigDecimal getAwardAmount() {
		return awardAmount;
	}

	public void setAwardAmount(BigDecimal awardAmount) {
		this.awardAmount = awardAmount;
	}

	public BigDecimal getRakeAmount() {
		return rakeAmount;
	}

	public void setRakeAmount(BigDecimal rakeAmount) {
		this.rakeAmount = rakeAmount;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
