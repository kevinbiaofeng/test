package com.xjw.entity.vo.data;

import java.math.BigDecimal;
import java.util.Date;

import com.alibaba.fastjson.JSONObject;

public class CwSummaryDayVo {
	private BigDecimal depositAmount;// 存款总金额
	private BigDecimal withdrawalAmount;// 提款总金额
	private Date dayTime;

	private JSONObject depositItems; 	// 存款额

	public BigDecimal getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(BigDecimal depositAmount) {
		this.depositAmount = depositAmount;
	}

	public BigDecimal getWithdrawalAmount() {
		return withdrawalAmount;
	}

	public void setWithdrawalAmount(BigDecimal withdrawalAmount) {
		this.withdrawalAmount = withdrawalAmount;
	}

	public Date getDayTime() {
		return dayTime;
	}

	public void setDayTime(Date dayTime) {
		this.dayTime = dayTime;
	}

	public JSONObject getDepositItems() {
		return depositItems;
	}

	public void setDepositItems(JSONObject depositItems) {
		this.depositItems = depositItems;
	}
}
