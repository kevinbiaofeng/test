package com.xjw.entity.po.cathectic;

import java.math.BigDecimal;

import com.xjw.base.entity.BasePo;

public class NewMgGame extends BasePo{
	private static final long serialVersionUID = 1L;
	private Long userId;
	private String loginName;
	private String playerName;
	private BigDecimal newMgBetAmount;		// 玩家投注总额
	private BigDecimal newMgNetAmount;		// 玩家输赢总额
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
	public BigDecimal getNewMgBetAmount() {
		return newMgBetAmount;
	}
	public void setNewMgBetAmount(BigDecimal newMgBetAmount) {
		this.newMgBetAmount = newMgBetAmount;
	}
	public BigDecimal getNewMgNetAmount() {
		return newMgNetAmount;
	}
	public void setNewMgNetAmount(BigDecimal newMgNetAmount) {
		this.newMgNetAmount = newMgNetAmount;
	}
}
