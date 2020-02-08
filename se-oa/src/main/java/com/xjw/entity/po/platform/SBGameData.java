package com.xjw.entity.po.platform;

import java.math.BigDecimal;
import java.util.Date;

import com.xjw.base.entity.BasePo;

public class SBGameData extends BasePo {
	private static final long serialVersionUID = 1L;
	private String dataType;
	private Long billNo;
	private String playerName;
	private String agentCode;
	private String gameCode;
	private BigDecimal netAmount;
	private Date betTime;
	private String gameType;
	private BigDecimal betAmount;
	private BigDecimal validBetAmount;
	private String flag;
	private String playType;
	private String tableCode;
	private String loginIp;
	private Date recalcuTime;
	private String platformId;
	private String platformType;
	private String stringex;
	private String remark;
	private String round;
	private Date localTime;
	private BigDecimal odds;
	private Integer oddsType;
	private Integer rakeStatus;

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public Long getBillNo() {
		return billNo;
	}

	public void setBillNo(Long billNo) {
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

	public String getPlatformType() {
		return platformType;
	}

	public void setPlatformType(String platformType) {
		this.platformType = platformType;
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

	public String getPlatformId() {
		return platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	public String getStringex() {
		return stringex;
	}

	public void setStringex(String stringex) {
		this.stringex = stringex;
	}

	public Date getLocalTime() {
		return localTime;
	}

	public void setLocalTime(Date localTime) {
		this.localTime = localTime;
	}

	public BigDecimal getOdds() {
		return odds;
	}

	public void setOdds(BigDecimal odds) {
		this.odds = odds;
	}

	public Integer getOddsType() {
		return oddsType;
	}

	public void setOddsType(Integer oddsType) {
		this.oddsType = oddsType;
	}

	public Integer getRakeStatus() {
		return rakeStatus;
	}

	public void setRakeStatus(Integer rakeStatus) {
		this.rakeStatus = rakeStatus;
	}

}
