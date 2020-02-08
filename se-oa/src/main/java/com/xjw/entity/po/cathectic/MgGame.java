package com.xjw.entity.po.cathectic;

import java.math.BigDecimal;

import com.xjw.base.entity.BasePo;

public class MgGame extends BasePo{
	private static final long serialVersionUID = 1L;
	private Long userId;
	private String loginName;
	private String playerName;
	private BigDecimal mgBetAmount;     // 玩家投注总额
	private BigDecimal mgNetAmount;		// 玩家输赢总额
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
	public BigDecimal getMgBetAmount() {
		return mgBetAmount;
	}
	public void setMgBetAmount(BigDecimal mgBetAmount) {
		this.mgBetAmount = mgBetAmount;
	}
	public BigDecimal getMgNetAmount() {
		return mgNetAmount;
	}
	public void setMgNetAmount(BigDecimal mgNetAmount) {
		this.mgNetAmount = mgNetAmount;
	}
	
}
