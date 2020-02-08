package com.xjw.entity.po.message;

import java.util.Date;

import com.xjw.base.entity.BasePo;
import com.xjw.kzenum.sys.YesORNoEnum;

/**
 * 站内信-用户关联表
 */
public class MessageUser extends BasePo {
	private static final long serialVersionUID = -1122785033027876552L;

	/** 站内信ID {@link Message.id} */
	private Long messageId;
	/** 收件人ID */
	private Long receiveUser;
	/** 收件人账号 */
	private String receiveName;
	/** 阅读状态 {@link YesORNoEnum} */
	private Integer readStatus;
	/** 阅读时间 */
	private Date readTime;

	public Long getMessageId() {
		return messageId;
	}

	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}

	public Long getReceiveUser() {
		return receiveUser;
	}

	public void setReceiveUser(Long receiveUser) {
		this.receiveUser = receiveUser;
	}

	public String getReceiveName() {
		return receiveName;
	}

	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}

	public Integer getReadStatus() {
		return readStatus;
	}

	public void setReadStatus(Integer readStatus) {
		this.readStatus = readStatus;
	}

	public Date getReadTime() {
		return readTime;
	}

	public void setReadTime(Date readTime) {
		this.readTime = readTime;
	}
}
