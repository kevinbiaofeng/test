package com.xjw.entity.po.activity;

import java.math.BigDecimal;
import java.util.Date;

import com.xjw.base.entity.BasePo;

public class UserRedBonus extends BasePo {

	private static final long serialVersionUID = 1L;

	private Long userId;

	private BigDecimal money;

	private Integer isOpen; // 是否打开红包 1 打开 2 未打开

	private Date openTime;

	private Long actId;

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

}