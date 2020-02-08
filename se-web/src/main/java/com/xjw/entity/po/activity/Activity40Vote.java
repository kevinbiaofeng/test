package com.xjw.entity.po.activity;

import com.xjw.base.entity.BasePo;

/**
 * 问卷调查-客服投票
 */
public class Activity40Vote extends BasePo {
	private static final long serialVersionUID = -1918900792036787277L;
	/** 投票会员ID */
	private Long userId;
	/** 客服名称 */
	private String csName;
	/** 评价 1:好评  2:差评 */
	private Integer evalFlag;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getCsName() {
		return csName;
	}

	public void setCsName(String csName) {
		this.csName = csName;
	}

	public Integer getEvalFlag() {
		return evalFlag;
	}

	public void setEvalFlag(Integer evalFlag) {
		this.evalFlag = evalFlag;
	}
}
