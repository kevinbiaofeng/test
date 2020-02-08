package com.xjw.entity.po.cathectic;

import java.math.BigDecimal;

import com.xjw.base.entity.BasePo;

public class AgGame extends BasePo{
	private static final long serialVersionUID = 1L;
	private Long userId;
	private String loginName;
	private String playerName;
	private String platformType;
	private BigDecimal agBetAmount;		// 玩家投注总额
	private BigDecimal agNetAmount;		// 玩家输赢总额
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public String getPlatformType() {
		return platformType;
	}
	public void setPlatformType(String platformType) {
		this.platformType = platformType;
	}
	public BigDecimal getAgBetAmount() {
		return agBetAmount;
	}
	public void setAgBetAmount(BigDecimal agBetAmount) {
		this.agBetAmount = agBetAmount;
	}
	public BigDecimal getAgNetAmount() {
		return agNetAmount;
	}
	public void setAgNetAmount(BigDecimal agNetAmount) {
		this.agNetAmount = agNetAmount;
	}
}
