package com.xjw.entity.po.message;

import com.xjw.base.entity.BasePo;

/**
 * 站内信
 */
public class Message extends BasePo {
	private static final long serialVersionUID = 8664378549141491131L;

	/** 标题 */
	private String title;
	/** 内容 */
	private String content;
	/** 收件人总数 */
	private Integer receiveCount; 
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getReceiveCount() {
		return receiveCount;
	}

	public void setReceiveCount(Integer receiveCount) {
		this.receiveCount = receiveCount;
	}
}
