package com.xjw.entity.po.activity;

import java.math.BigDecimal;
import java.util.Date;

import com.xjw.base.entity.BasePo;
import com.xjw.utility.DateUtil;
import com.xjw.utility.DateUtil.IntevalType;

public class UserRedBonus extends BasePo {

	private static final long serialVersionUID = 1L;

	private Long userId;

	private BigDecimal money;

	private Integer isOpen; // 是否打开红包 1 打开 2 未打开

	private Date openTime;

	private Long actId;

	private String userName;

	private String createUserName;

	private String actName;

	public long getEndDays(){
		return DateUtil.getInterval(this.getCreateTime(), IntevalType.DAY);
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

	public Integer getIsOpen() {
		return isOpen;
	}

	public void setIsOpen(Integer isOpen) {
		this.isOpen = isOpen;
	}

	public Date getOpenTime() {
		return openTime;
	}

	public void setOpenTime(Date openTime) {
		this.openTime = openTime;
	}

	public Long getActId() {
		return actId;
	}

	public void setActId(Long actId) {
		this.actId = actId;
	}

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

	public String getActName() {
		return actName;
	}

	public void setActName(String actName) {
		this.actName = actName;
	}

}