package com.xjw.entity.po.data;

import java.math.BigDecimal;
import java.util.Date;

import com.xjw.base.entity.BasePo;

public class SummaryDay extends BasePo {
	private static final long serialVersionUID = -4903445171096688997L;

	private Integer userCount;
	private BigDecimal depositAmount;// 存款总金额
	private BigDecimal withdrawalAmount;// 提款总金额
	private BigDecimal promotionAmount; // 资金调整总额
	private BigDecimal agBetAmount;		// 玩家投注总额
	private BigDecimal agNetAmount;		// 玩家输赢总额
	private BigDecimal ptBetAmount;
	private BigDecimal ptNetAmount;
	private BigDecimal mgBetAmount;
	private BigDecimal mgNetAmount;
	private BigDecimal sbBetAmount;
	private BigDecimal sbNetAmount;
	private BigDecimal fishBetAmount;
	private BigDecimal fishNetAmount;
	private BigDecimal qpBetAmount;
	private BigDecimal qpNetAmount;
	private BigDecimal endoBetAmount;
	private BigDecimal endoNetAmount;
	private BigDecimal xinBetAmount;
	private BigDecimal xinNetAmount;
	private BigDecimal newPtBetAmount;
	private BigDecimal newPtNetAmount;
	private BigDecimal newMgBetAmount;
	private BigDecimal newMgNetAmount;
	private Date dayTime;
	private String depositExt;
	
	/** 统计投注总额 */
	public BigDecimal getTotalBetAmount(){
		return agBetAmount.add(ptBetAmount).add(mgBetAmount).add(sbBetAmount)
				.add(fishBetAmount).add(qpBetAmount).add(endoBetAmount)
				.add(xinBetAmount).add(newPtBetAmount).add(newMgBetAmount);
	}
	
	/** 统计输赢总额 */
	public BigDecimal getTotalNetAmount(){
		return agNetAmount.add(ptNetAmount).add(mgNetAmount).add(sbNetAmount)
				.add(fishNetAmount).add(qpNetAmount).add(endoNetAmount)
				.add(xinNetAmount).add(newPtNetAmount).add(newMgNetAmount);
	}

	public Integer getUserCount() {
		return userCount;
	}

	public void setUserCount(Integer userCount) {
		this.userCount = userCount;
	}

	public BigDecimal getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(BigDecimal depositAmount) {
		this.depositAmount = depositAmount;
	}

	public BigDecimal getWithdrawalAmount() {
		return withdrawalAmount;
	}

	public void setWithdrawalAmount(BigDecimal withdrawalAmount) {
		this.withdrawalAmount = withdrawalAmount;
	}
	
	public BigDecimal getPromotionAmount() {
		return promotionAmount;
	}

	public void setPromotionAmount(BigDecimal promotionAmount) {
		this.promotionAmount = promotionAmount;
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

	public BigDecimal getPtBetAmount() {
		return ptBetAmount;
	}

	public void setPtBetAmount(BigDecimal ptBetAmount) {
		this.ptBetAmount = ptBetAmount;
	}

	public BigDecimal getPtNetAmount() {
		return ptNetAmount;
	}

	public void setPtNetAmount(BigDecimal ptNetAmount) {
		this.ptNetAmount = ptNetAmount;
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

	public BigDecimal getQpBetAmount() {
		return qpBetAmount;
	}

	public void setQpBetAmount(BigDecimal qpBetAmount) {
		this.qpBetAmount = qpBetAmount;
	}

	public BigDecimal getQpNetAmount() {
		return qpNetAmount;
	}

	public void setQpNetAmount(BigDecimal qpNetAmount) {
		this.qpNetAmount = qpNetAmount;
	}
	
	public BigDecimal getEndoBetAmount() {
		return endoBetAmount;
	}

	public void setEndoBetAmount(BigDecimal endoBetAmount) {
		this.endoBetAmount = endoBetAmount;
	}

	public BigDecimal getEndoNetAmount() {
		return endoNetAmount;
	}

	public void setEndoNetAmount(BigDecimal endoNetAmount) {
		this.endoNetAmount = endoNetAmount;
	}

	public BigDecimal getXinBetAmount() {
		return xinBetAmount;
	}

	public void setXinBetAmount(BigDecimal xinBetAmount) {
		this.xinBetAmount = xinBetAmount;
	}

	public BigDecimal getXinNetAmount() {
		return xinNetAmount;
	}

	public void setXinNetAmount(BigDecimal xinNetAmount) {
		this.xinNetAmount = xinNetAmount;
	}

	public BigDecimal getNewPtBetAmount() {
		return newPtBetAmount;
	}

	public void setNewPtBetAmount(BigDecimal newPtBetAmount) {
		this.newPtBetAmount = newPtBetAmount;
	}

	public BigDecimal getNewPtNetAmount() {
		return newPtNetAmount;
	}

	public void setNewPtNetAmount(BigDecimal newPtNetAmount) {
		this.newPtNetAmount = newPtNetAmount;
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

	public Date getDayTime() {
		return dayTime;
	}

	public void setDayTime(Date dayTime) {
		this.dayTime = dayTime;
	}

	public String getDepositExt() {
		return depositExt;
	}

	public void setDepositExt(String depositExt) {
		this.depositExt = depositExt;
	}
}
