package com.xjw.entity.po.platform;

import java.math.BigDecimal;

import com.xjw.base.entity.BasePo;

/**
 * 平台余额
 */
public class PlatformWallet extends BasePo{
	private static final long serialVersionUID = -8029785928679381593L;
	
	/** 用户ID */
	private Long userId;
	/** 用户名 */
	private String loginName;
	/** 代理用户ID */
	private long agentUserId;
	/** 代理用户名 */
	private String agentLoginName;
	/** 主平台余额 */
	private BigDecimal mainAmount;
	/** AG国际厅余额 */
	private BigDecimal aggjAmount;
	/** AG急速厅余额 */
	private BigDecimal agjsAmount;
	/** pt余额 */
	private BigDecimal ptAmount;
	/** mg余额 */
	private BigDecimal mgAmount;
	/** 沙巴余额余额 */
	private BigDecimal sbAmount;

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

	public long getAgentUserId() {
		return agentUserId;
	}

	public void setAgentUserId(long agentUserId) {
		this.agentUserId = agentUserId;
	}

	public String getAgentLoginName() {
		return agentLoginName;
	}

	public void setAgentLoginName(String agentLoginName) {
		this.agentLoginName = agentLoginName;
	}
	
	public BigDecimal getMainAmount() {
		return mainAmount;
	}

	public void setMainAmount(BigDecimal mainAmount) {
		this.mainAmount = mainAmount;
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

	public BigDecimal getSbAmount() {
		return sbAmount;
	}

	public void setSbAmount(BigDecimal sbAmount) {
		this.sbAmount = sbAmount;
	}

}
