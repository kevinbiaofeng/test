package com.xjw.entity.po.platform;

import java.math.BigDecimal;
import java.util.Date;

import com.xjw.base.entity.BasePo;

public class MGGameData extends BasePo {
	private static final long serialVersionUID = 1L;
	private String dataType;
	private String billNo;
	private String playerName;
	private String agentCode;
	private String gameCode;
	private BigDecimal netAmount;
	private Date betTime;
	private String gameType;
	private String gameTypeName;
	private BigDecimal betAmount;
	private BigDecimal validBetAmount;
	private String flag;
	private String playType;
	private String tableCode;
	private String loginIp;
	private Date recalcuTime;
	private String platformType;
	private String remark;
	private String round;
	private String result;
	private BigDecimal betAmountBonus;
	private BigDecimal netAmountBonus;
	private Date localTime;
	private Integer rakeStatus;
	private Integer gameCategory;

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getAgentCode() {
		return agentCode;
	}

	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
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

	public Date getBetTime() {
		return betTime;
	}

	public void setBetTime(Date betTime) {
		this.betTime = betTime;
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

	public String getPlayType() {
		return playType;
	}

	public void setPlayType(String playType) {
		this.playType = playType;
	}

	public String getTableCode() {
		return tableCode;
	}

	public void setTableCode(String tableCode) {
		this.tableCode = tableCode;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public Date getRecalcuTime() {
		return recalcuTime;
	}

	public void setRecalcuTime(Date recalcuTime) {
		this.recalcuTime = recalcuTime;
	}

	public String getGameTypeName() {
		return gameTypeName;
	}

	public void setGameTypeName(String gameTypeName) {
		this.gameTypeName = gameTypeName;
	}

	public String getPlatformType() {
		return platformType;
	}

	public void setPlatformType(String platformType) {
		this.platformType = platformType;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRound() {
		return round;
	}

	public void setRound(String round) {
		this.round = round;
	}

	public BigDecimal getBetAmountBonus() {
		return betAmountBonus;
	}

	public void setBetAmountBonus(BigDecimal betAmountBonus) {
		this.betAmountBonus = betAmountBonus;
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

	public Integer getRakeStatus() {
		return rakeStatus;
	}

	public void setRakeStatus(Integer rakeStatus) {
		this.rakeStatus = rakeStatus;
	}

	public Integer getGameCategory() {
		return gameCategory;
	}

	public void setGameCategory(Integer gameCategory) {
		this.gameCategory = gameCategory;
	}

}
