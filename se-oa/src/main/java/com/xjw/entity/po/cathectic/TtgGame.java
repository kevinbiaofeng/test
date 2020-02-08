package com.xjw.entity.po.cathectic;

import java.math.BigDecimal;

import com.xjw.base.entity.BasePo;

public class TtgGame extends BasePo{
	private static final long serialVersionUID = 1L;
	private Long userId;
	private String loginName;
	private String playerName;
	private BigDecimal ttgBetAmount;		// 玩家投注总额
	private BigDecimal ttgNetAmount;		// 玩家输赢总额
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
	public BigDecimal getTtgBetAmount() {
		return ttgBetAmount;
	}
	public void setTtgBetAmount(BigDecimal ttgBetAmount) {
		this.ttgBetAmount = ttgBetAmount;
	}
	public BigDecimal getTtgNetAmount() {
		return ttgNetAmount;
	}
	public void setTtgNetAmount(BigDecimal ttgNetAmount) {
		this.ttgNetAmount = ttgNetAmount;
	}
}
