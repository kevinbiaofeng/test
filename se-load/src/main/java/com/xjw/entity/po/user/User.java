package com.xjw.entity.po.user;

import java.util.Date;

import com.xjw.base.entity.BasePo;
import com.xjw.util.PromoCodeUtils;

public class User extends BasePo {

	private static final long serialVersionUID = 1L;

	private String pwd;
	private String loginName;
	private Integer type;
	private Long parentId;
	private String registerIp;
	private String registerIpCityInfo;
	private String sessionSid;
	private Date sessionSidTime;

	private String name;
	private Integer sex;
	private Integer level;
	
	/** 生成用户推广代码 */
	public String getPromoCode(){
		return PromoCodeUtils.encode(super.getId());
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getRegisterIp() {
		return registerIp;
	}

	public void setRegisterIp(String registerIp) {
		this.registerIp = registerIp;
	}

	public String getRegisterIpCityInfo() {
		return registerIpCityInfo;
	}

	public void setRegisterIpCityInfo(String registerIpCityInfo) {
		this.registerIpCityInfo = registerIpCityInfo;
	}

	public String getSessionSid() {
		return sessionSid;
	}

	public void setSessionSid(String sessionSid) {
		this.sessionSid = sessionSid;
	}

	public Date getSessionSidTime() {
		return sessionSidTime;
	}

	public void setSessionSidTime(Date sessionSidTime) {
		this.sessionSidTime = sessionSidTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

}
