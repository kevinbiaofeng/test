package com.xjw.entity.po.user;

import java.util.Date;

import com.xjw.base.entity.BasePo;
import com.xjw.kzenum.sys.YesORNoEnum;

public class MemberCheck extends BasePo {
	private static final long serialVersionUID = -2833955676017891844L;

	private Long userId;

	/** 邮箱是否验证 {@link YesORNoEnum} */
	private Integer emailFlag;
	/** 邮箱验证时间 */
	private Date emailTime;
	/** 手机是否验证 {@link YesORNoEnum} */
	private Integer phoneFlag;
	/** 手机验证时间 */
	private Date phoneTime;
	/** 身份证是否验证 {@link YesORNoEnum} */
	private Integer idCardFlag;
	/** 身份证验证时间 */
	private Date idCardTime;
	/** 银行卡是否验证 {@link YesORNoEnum} */
	private Integer bankCardFlag;
	/** 银行卡验证时间 */
	private Date bankcardTime;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getEmailFlag() {
		return emailFlag;
	}

	public void setEmailFlag(Integer emailFlag) {
		this.emailFlag = emailFlag;
	}

	public Date getEmailTime() {
		return emailTime;
	}

	public void setEmailTime(Date emailTime) {
		this.emailTime = emailTime;
	}

	public Integer getPhoneFlag() {
		return phoneFlag;
	}

	public void setPhoneFlag(Integer phoneFlag) {
		this.phoneFlag = phoneFlag;
	}

	public Date getPhoneTime() {
		return phoneTime;
	}

	public void setPhoneTime(Date phoneTime) {
		this.phoneTime = phoneTime;
	}

	public Integer getIdCardFlag() {
		return idCardFlag;
	}

	public void setIdCardFlag(Integer idCardFlag) {
		this.idCardFlag = idCardFlag;
	}

	public Date getIdCardTime() {
		return idCardTime;
	}

	public void setIdCardTime(Date idCardTime) {
		this.idCardTime = idCardTime;
	}

	public Integer getBankCardFlag() {
		return bankCardFlag;
	}

	public void setBankCardFlag(Integer bankCardFlag) {
		this.bankCardFlag = bankCardFlag;
	}

	public Date getBankcardTime() {
		return bankcardTime;
	}

	public void setBankcardTime(Date bankcardTime) {
		this.bankcardTime = bankcardTime;
	}
}
