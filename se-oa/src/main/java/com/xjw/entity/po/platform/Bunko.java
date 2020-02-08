package com.xjw.entity.po.platform;

import java.math.BigDecimal;

import com.xjw.base.entity.BasePo;

/**
 * 各平台输赢
 */
public class Bunko extends BasePo {
	private static final long serialVersionUID = 1L;
	private String loginName;
	private BigDecimal aggjAmount;
	private BigDecimal agjsAmount;
	private BigDecimal ptAmount;
	private BigDecimal newPtAmount;
	private BigDecimal mgAmount;
	private BigDecimal newMgAmount;
	private BigDecimal ttgAmount;
	private BigDecimal endoAmount;
	private BigDecimal xinAmount;
	private BigDecimal qpAmount;
	private BigDecimal sbAmount;
	private BigDecimal fishAmount;
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public BigDecimal getAggjAmount() {
		return aggjAmount;
	}
	public void setAggjAmount(BigDecimal aggjAmount) {
		this.aggjAmount = aggjAmount;
	}
	public BigDecimal getAgjsAmount() {
		return agjsAmount;
	}
	public void setAgjsAmount(BigDecimal agjsAmount) {
		this.agjsAmount = agjsAmount;
	}
	public BigDecimal getPtAmount() {
		return ptAmount;
	}
	public void setPtAmount(BigDecimal ptAmount) {
		this.ptAmount = ptAmount;
	}
	public BigDecimal getMgAmount() {
		return mgAmount;
	}
	public void setMgAmount(BigDecimal mgAmount) {
		this.mgAmount = mgAmount;
	}
	public BigDecimal getNewMgAmount() {
		return newMgAmount;
	}
	public void setNewMgAmount(BigDecimal newMgAmount) {
		this.newMgAmount = newMgAmount;
	}
	public BigDecimal getTtgAmount() {
		return ttgAmount;
	}
	public void setTtgAmount(BigDecimal ttgAmount) {
		this.ttgAmount = ttgAmount;
	}
	public BigDecimal getEndoAmount() {
		return endoAmount;
	}
	public void setEndoAmount(BigDecimal endoAmount) {
		this.endoAmount = endoAmount;
	}
	public BigDecimal getXinAmount() {
		return xinAmount;
	}
	public void setXinAmount(BigDecimal xinAmount) {
		this.xinAmount = xinAmount;
	}
	public BigDecimal getQpAmount() {
		return qpAmount;
	}
	public void setQpAmount(BigDecimal qpAmount) {
		this.qpAmount = qpAmount;
	}
	public BigDecimal getSbAmount() {
		return sbAmount;
	}
	public void setSbAmount(BigDecimal sbAmount) {
		this.sbAmount = sbAmount;
	}
	public BigDecimal getFishAmount() {
		return fishAmount;
	}
	public void setFishAmount(BigDecimal fishAmount) {
		this.fishAmount = fishAmount;
	}
	public BigDecimal getNewPtAmount() {
		return newPtAmount;
	}
	public void setNewPtAmount(BigDecimal newPtAmount) {
		this.newPtAmount = newPtAmount;
	}
}
