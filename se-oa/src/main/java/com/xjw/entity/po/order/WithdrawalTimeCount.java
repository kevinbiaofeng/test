package com.xjw.entity.po.order;

import com.xjw.base.entity.BasePo;

public class WithdrawalTimeCount extends BasePo{
	private static final long serialVersionUID = 1L;
	private String loginName;//用户名
	private Long userId;//财务ID 、风控ID
	private int countUser;//统计数
	private String type; //财务finance 或 风控risk
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public int getCountUser() {
		return countUser;
	}
	public void setCountUser(int countUser) {
		this.countUser = countUser;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
