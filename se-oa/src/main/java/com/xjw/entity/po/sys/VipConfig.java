package com.xjw.entity.po.sys;

import java.math.BigDecimal;

import com.xjw.base.entity.BasePo;

/**
 * VIP配置
 * @author qing
 */
public class VipConfig extends BasePo{
	private static final long serialVersionUID = 1L;
	
	private Integer level;//会员等级
	private BigDecimal monthDepositAmount;//月累计存款
	private BigDecimal weekBetAmount; //周有效投注
	private BigDecimal monthChipAmount; //每月免费筹码
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public BigDecimal getMonthDepositAmount() {
		return monthDepositAmount;
	}
	public void setMonthDepositAmount(BigDecimal monthDepositAmount) {
		this.monthDepositAmount = monthDepositAmount;
	}
	public BigDecimal getWeekBetAmount() {
		return weekBetAmount;
	}
	public void setWeekBetAmount(BigDecimal weekBetAmount) {
		this.weekBetAmount = weekBetAmount;
	}
	public BigDecimal getMonthChipAmount() {
		return monthChipAmount;
	}
	public void setMonthChipAmount(BigDecimal monthChipAmount) {
		this.monthChipAmount = monthChipAmount;
	}
}
