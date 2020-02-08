package com.xjw.entity.po.user;

import com.xjw.base.entity.BasePo;

public class MemberCallcsDetail extends BasePo {

	private static final long serialVersionUID = 1L;
	private Long userId;
	private Integer callcsStatus;
	private Integer callcsType;
	private String remark;
	
	/** 临时变量 */
	private String updateUserName;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public Integer getCallcsStatus() {
		return callcsStatus;
	}

	public void setCallcsStatus(Integer callcsStatus) {
		this.callcsStatus = callcsStatus;
	}

	public Integer getCallcsType() {
		return callcsType;
	}

	public void setCallcsType(Integer callcsType) {
		this.callcsType = callcsType;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getUpdateUserName() {
		return updateUserName;
	}

	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}
}
