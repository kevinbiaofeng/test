package com.xjw.entity.po.activity;

import java.math.BigDecimal;

import com.xjw.base.entity.BasePo;

public class WithdrawLimit extends BasePo {
	private static final long serialVersionUID = 1L;
	private Long userId;
	private BigDecimal oneUp;
	private BigDecimal dayUp;
	private String remark;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public BigDecimal getOneUp() {
		return oneUp;
	}

	public void setOneUp(BigDecimal oneUp) {
		this.oneUp = oneUp;
	}

	public BigDecimal getDayUp() {
		return dayUp;
	}

	public void setDayUp(BigDecimal dayUp) {
		this.dayUp = dayUp;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
