package com.xjw.entity.po.notice;

import java.math.BigDecimal;
import java.util.Date;

import com.xjw.base.entity.BasePo;
import com.xjw.kzenum.notice.NoticePromptTypeEnum;
import com.xjw.kzenum.platform.PlatformTypeEnum;

/**
 * 弹窗消息
 */
public class NoticePrompt extends BasePo {
	private static final long serialVersionUID = 2170262113605325484L;

	/** 用户名 */
	private String name;
	/** 中奖描述 */
	private String content;
	/** 中奖金额 */
	private BigDecimal amount;
	/** 平台类型 {@link PlatformTypeEnum} */
	private Integer platformType;
	/** 弹窗消息类型  {@link NoticePromptTypeEnum}*/
	private Integer type;
	/** 中奖时间 */
	private Date winTime;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Integer getPlatformType() {
		return platformType;
	}

	public void setPlatformType(Integer platformType) {
		this.platformType = platformType;
	}

	public Date getWinTime() {
		return winTime;
	}

	public void setWinTime(Date winTime) {
		this.winTime = winTime;
	}
}
