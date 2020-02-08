package com.xjw.entity.po.user;

import java.util.Date;

import com.xjw.base.entity.BasePo;

public class Member extends BasePo {

	private static final long serialVersionUID = 1L;
	private String name;
	private String email;
	private Integer sex;
	private String phone;
	private String qq;
	private Integer vipType;
	private Date birthday;
	private Long userId;
	private String loginName;
	private Integer privacyFlag; //1显示 2隐藏

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public Integer getVipType() {
		return vipType;
	}

	public void setVipType(Integer vipType) {
		this.vipType = vipType;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getPrivacyFlag() {
		return privacyFlag;
	}

	public void setPrivacyFlag(Integer privacyFlag) {
		this.privacyFlag = privacyFlag;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	
}
