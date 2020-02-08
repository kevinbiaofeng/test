package com.xjw.entity.po.cathectic;

import java.math.BigDecimal;

import com.xjw.base.entity.BasePo;

public class SbGame extends BasePo{
	private static final long serialVersionUID = 1L;
	private Long userId;
	private String loginName;
	private String playerName;
	private BigDecimal sbBetAmount;		// 玩家投注总额
	private BigDecimal sbNetAmount;		// 玩家输赢总额
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
	public BigDecimal getSbBetAmount() {
		return sbBetAmount;
	}
	public void setSbBetAmount(BigDecimal sbBetAmount) {
		this.sbBetAmount = sbBetAmount;
	}
	public BigDecimal getSbNetAmount() {
		return sbNetAmount;
	}
	public void setSbNetAmount(BigDecimal sbNetAmount) {
		this.sbNetAmount = sbNetAmount;
	}
	
}
