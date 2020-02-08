package com.xjw.entity.po.platform;

import java.math.BigDecimal;

import com.xjw.base.entity.BasePo;

/**
 * 有效投注
 */
public class Cathectic extends BasePo {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String loginName;
	private BigDecimal aggjBetAmount;
	private BigDecimal agjsBetAmount;
	private BigDecimal ptBetAmount;
	private BigDecimal newPtBetAmount;
	private BigDecimal mgBetAmount;
	private BigDecimal newMgBetAmount;
	private BigDecimal xinBetAmount;
	private BigDecimal fishBetAmount;
	private BigDecimal sbBetAmount;
	private BigDecimal qpBetAmount;
	private BigDecimal ttgBetAmount;
	private BigDecimal endoBetAmount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public BigDecimal getAggjBetAmount() {
		return aggjBetAmount;
	}

	public void setAggjBetAmount(BigDecimal aggjBetAmount) {
		this.aggjBetAmount = aggjBetAmount;
	}

	public BigDecimal getAgjsBetAmount() {
		return agjsBetAmount;
	}

	public void setAgjsBetAmount(BigDecimal agjsBetAmount) {
		this.agjsBetAmount = agjsBetAmount;
	}
	
	public BigDecimal getPtBetAmount() {
		return ptBetAmount;
	}

	public void setPtBetAmount(BigDecimal ptBetAmount) {
		this.ptBetAmount = ptBetAmount;
	}

	public BigDecimal getMgBetAmount() {
		return mgBetAmount;
	}

	public void setMgBetAmount(BigDecimal mgBetAmount) {
		this.mgBetAmount = mgBetAmount;
	}

	public BigDecimal getNewMgBetAmount() {
		return newMgBetAmount;
	}

	public void setNewMgBetAmount(BigDecimal newMgBetAmount) {
		this.newMgBetAmount = newMgBetAmount;
	}

	public BigDecimal getXinBetAmount() {
		return xinBetAmount;
	}

	public void setXinBetAmount(BigDecimal xinBetAmount) {
		this.xinBetAmount = xinBetAmount;
	}

	public BigDecimal getFishBetAmount() {
		return fishBetAmount;
	}

	public void setFishBetAmount(BigDecimal fishBetAmount) {
		this.fishBetAmount = fishBetAmount;
	}

	public BigDecimal getSbBetAmount() {
		return sbBetAmount;
	}

	public void setSbBetAmount(BigDecimal sbBetAmount) {
		this.sbBetAmount = sbBetAmount;
	}

	public BigDecimal getQpBetAmount() {
		return qpBetAmount;
	}

	public void setQpBetAmount(BigDecimal qpBetAmount) {
		this.qpBetAmount = qpBetAmount;
	}

	public BigDecimal getNewPtBetAmount() {
		return newPtBetAmount;
	}

	public void setNewPtBetAmount(BigDecimal newPtBetAmount) {
		this.newPtBetAmount = newPtBetAmount;
	}

	public BigDecimal getTtgBetAmount() {
		return ttgBetAmount;
	}

	public void setTtgBetAmount(BigDecimal ttgBetAmount) {
		this.ttgBetAmount = ttgBetAmount;
	}

	public BigDecimal getEndoBetAmount() {
		return endoBetAmount;
	}

	public void setEndoBetAmount(BigDecimal endoBetAmount) {
		this.endoBetAmount = endoBetAmount;
	}

}
