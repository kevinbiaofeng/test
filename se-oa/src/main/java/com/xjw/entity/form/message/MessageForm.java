package com.xjw.entity.form.message;

import com.xjw.entity.form.BaseForm;

public class MessageForm extends BaseForm {
	private static final long serialVersionUID = -5214121893817446630L;
	
	private Long id;
	private String likeTitle;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLikeTitle() {
		return likeTitle;
	}
	public void setLikeTitle(String likeTitle) {
		this.likeTitle = likeTitle;
	}
}
