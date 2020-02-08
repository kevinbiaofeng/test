package com.xjw.entity.po.cathectic;

import java.math.BigDecimal;

import com.xjw.base.entity.BasePo;

public class FishGame extends BasePo{
	private static final long serialVersionUID = 1L;
	private Long userId;
	private String loginName;
	private String playerName;
	private BigDecimal fishBetAmount;		// 玩家投注总额
	private BigDecimal fishNetAmount;		// 玩家输赢总额
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
	public BigDecimal getFishBetAmount() {
		return fishBetAmount;
	}
	public void setFishBetAmount(BigDecimal fishBetAmount) {
		this.fishBetAmount = fishBetAmount;
	}
	public BigDecimal getFishNetAmount() {
		return fishNetAmount;
	}
	public void setFishNetAmount(BigDecimal fishNetAmount) {
		this.fishNetAmount = fishNetAmount;
	}
		
}
