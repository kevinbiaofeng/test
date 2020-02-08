package com.xjw.entity.po.platform;

import java.math.BigDecimal;
import java.util.Date;

import com.xjw.base.entity.BasePo;

public class NewPtGameData extends BasePo{
	private static final long serialVersionUID = 4029520667128160631L;
	private Long billNo;             //注单流水号
	private String playerName;       //游戏账户名称
	private String slotType;     	 //游戏类型
	private String gameType;		 //游戏编号
	private BigDecimal beforeCredit; //投注之后余额
	private BigDecimal betAmount;	 //投注金额
	private BigDecimal netAmount;	 //玩家输赢额度
	private String deviceType;		 //设备类型
	private Date betTime;			 //下注时间
	private Date localTime;			 //北京时间
	private String loginIp;			 //IP地址
	private Long userId;			 //用户ID
	private String remark;			 //备注

	public Long getBillNo() {
		return billNo;
	}
	public void setBillNo(Long billNo) {
		this.billNo = billNo;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public String getSlotType() {
		return slotType;
	}
	public void setSlotType(String slotType) {
		this.slotType = slotType;
	}
	public String getGameType() {
		return gameType;
	}
	public void setGameType(String gameType) {
		this.gameType = gameType;
	}
	public BigDecimal getBeforeCredit() {
		return beforeCredit;
	}
	public void setBeforeCredit(BigDecimal beforeCredit) {
		this.beforeCredit = beforeCredit;
	}
	public BigDecimal getBetAmount() {
		return betAmount;
	}
	public void setBetAmount(BigDecimal betAmount) {
		this.betAmount = betAmount;
	}
	public BigDecimal getNetAmount() {
		return netAmount;
	}
	public void setNetAmount(BigDecimal netAmount) {
		this.netAmount = netAmount;
	}
	public String getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	public Date getBetTime() {
		return betTime;
	}
	public void setBetTime(Date betTime) {
		this.betTime = betTime;
	}
	public Date getLocalTime() {
		return localTime;
	}
	public void setLocalTime(Date localTime) {
		this.localTime = localTime;
	}
	public String getLoginIp() {
		return loginIp;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
