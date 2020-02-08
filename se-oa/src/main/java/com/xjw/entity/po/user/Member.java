package com.xjw.entity.po.user;

import java.math.BigDecimal;
import java.util.Date;

import com.xjw.base.entity.BasePo;

public class Member extends BasePo {

	private static final long serialVersionUID = 1L;
	private Long memberId;
	private String loginName;
	private String userName;
	private Long userId;
	private String pwd;
	private String name;
	private String email;
	private Integer sex;
	private String phone;
	private String qq;
	private Integer vipType;
	private Date birthday;
	private String registerIp;
	private String loginIp;
	private Date loginTime;
	private String loginIpCityInfo;
	private String registerIpCityInfo;
	private Long parentId;
	private Float totalMoney;
	private Float integral;
	private BigDecimal depositAmount;
	private BigDecimal withdrawalAmount;
	/** 隐私信息标记 1:显示 2:隐藏 */
	private Integer privacyFlag;

	private Integer callcsType;
	private Integer callcsStatus;

	/** 临时变量 - 推荐人 */
	private String referenceName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Float getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(Float totalMoney) {
		this.totalMoney = totalMoney;
	}

	public Float getIntegral() {
		return integral;
	}

	public void setIntegral(Float integral) {
		this.integral = integral;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getRegisterIpCityInfo() {
		return registerIpCityInfo;
	}

	public void setRegisterIpCityInfo(String registerIpCityInfo) {
		this.registerIpCityInfo = registerIpCityInfo;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

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

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

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

	public String getRegisterIp() {
		return registerIp;
	}

	public void setRegisterIp(String registerIp) {
		this.registerIp = registerIp;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public String getLoginIpCityInfo() {
		return loginIpCityInfo;
	}

	public void setLoginIpCityInfo(String loginIpCityInfo) {
		this.loginIpCityInfo = loginIpCityInfo;
	}

	public BigDecimal getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(BigDecimal depositAmount) {
		this.depositAmount = depositAmount;
	}

	public BigDecimal getWithdrawalAmount() {
		return withdrawalAmount;
	}

	public void setWithdrawalAmount(BigDecimal withdrawalAmount) {
		this.withdrawalAmount = withdrawalAmount;
	}

	public String getReferenceName() {
		return referenceName;
	}

	public void setReferenceName(String referenceName) {
		this.referenceName = referenceName;
	}

	public Integer getCallcsType() {
		return callcsType;
	}

	public void setCallcsType(Integer callcsType) {
		this.callcsType = callcsType;
	}

	public Integer getCallcsStatus() {
		return callcsStatus;
	}

	public void setCallcsStatus(Integer callcsStatus) {
		this.callcsStatus = callcsStatus;
	}

	public Integer getPrivacyFlag() {
		return privacyFlag;
	}

	public void setPrivacyFlag(Integer privacyFlag) {
		this.privacyFlag = privacyFlag;
	}
}
