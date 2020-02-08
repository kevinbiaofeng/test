package com.xjw.entity.po.sys;

import java.math.BigDecimal;

import com.xjw.base.entity.BasePo;

/**
 * 会员配置
 */
public class VipConfig extends BasePo {
	private static final long serialVersionUID = -8854148832724902501L;
	/** 会员等级 */
	private Integer level;
	/** 月累计存款 */
	private BigDecimal monthDepositAmount;
	/** 周有效投注 */
	private BigDecimal weekBetAmount;
	/** 每月免费筹码 */
	private BigDecimal monthChipAmount;

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
