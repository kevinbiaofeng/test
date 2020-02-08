package com.xjw.entity.po.platform;

import java.math.BigDecimal;
import java.util.Date;

import com.xjw.base.entity.BasePo;

public class AGGameData extends BasePo {
	private static final long serialVersionUID = 1L;
	private Long billNo;
	private String gameCode;
	private BigDecimal netAmount;
	private String gameType;
	private BigDecimal betAmount;
	private BigDecimal validBetAmount;
	private String flag;
	private String tableCode;
	private BigDecimal betAmountBase;
	private BigDecimal betAmountBonus;
	private BigDecimal netAmountBase;
	private BigDecimal netAmountBonus;
	private Date localTime;

	public Long getBillNo() {
		return billNo;
	}

	public void setBillNo(Long billNo) {
		this.billNo = billNo;
	}

	public String getGameCode() {
		return gameCode;
	}

	public void setGameCode(String gameCode) {
		this.gameCode = gameCode;
	}

	public BigDecimal getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(BigDecimal netAmount) {
		this.netAmount = netAmount;
	}

	public String getGameType() {
		return gameType;
	}

	public void setGameType(String gameType) {
		this.gameType = gameType;
	}

	public BigDecimal getBetAmount() {
		return betAmount;
	}

	public void setBetAmount(BigDecimal betAmount) {
		this.betAmount = betAmount;
	}

	public BigDecimal getValidBetAmount() {
		return validBetAmount;
	}

	public void setValidBetAmount(BigDecimal validBetAmount) {
		this.validBetAmount = validBetAmount;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getTableCode() {
		return tableCode;
	}

	public void setTableCode(String tableCode) {
		this.tableCode = tableCode;
	}

	public BigDecimal getBetAmountBase() {
		return betAmountBase;
	}

	public void setBetAmountBase(BigDecimal betAmountBase) {
		this.betAmountBase = betAmountBase;
	}

	public BigDecimal getBetAmountBonus() {
		return betAmountBonus;
	}

	public void setBetAmountBonus(BigDecimal betAmountBonus) {
		this.betAmountBonus = betAmountBonus;
	}

	public BigDecimal getNetAmountBase() {
		return netAmountBase;
	}

	public void setNetAmountBase(BigDecimal netAmountBase) {
		this.netAmountBase = netAmountBase;
	}

	public BigDecimal getNetAmountBonus() {
		return netAmountBonus;
	}

	public void setNetAmountBonus(BigDecimal netAmountBonus) {
		this.netAmountBonus = netAmountBonus;
	}

	public Date getLocalTime() {
		return localTime;
	}

	public void setLocalTime(Date localTime) {
		this.localTime = localTime;
	}

}
