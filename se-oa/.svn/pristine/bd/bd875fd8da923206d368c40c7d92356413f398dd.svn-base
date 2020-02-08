package com.xjw.entity.po.sys;

import java.util.Date;

import com.xjw.base.entity.BasePo;
import com.xjw.kzenum.sys.EmailSmsType;
import com.xjw.kzenum.sys.SmsUseStatus;

/**
 * 验证码短信发送至邮箱
 */
public class EmailSms extends BasePo {
	private static final long serialVersionUID = -1812282845978180227L;

	private Long id;
	/** 用户ID */
	private Long userId;
	/** 登录账号 */
	private String loginName;
	/** 邮箱 */
	private String email;
	/** 验证码 */
	private String sendCode;
	/** 短信类别 {@link EmailSmsType} */
	private Integer type;
	/** 过期时间 */
	private Date expireTime;
	/** 使用状态  {@link SmsUseStatus}*/
	private Integer useStatus;
	/** 使用时间 */
	private Date useTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSendCode() {
		return sendCode;
	}

	public void setSendCode(String sendCode) {
		this.sendCode = sendCode;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Date getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}

	public Integer getUseStatus() {
		return useStatus;
	}

	public void setUseStatus(Integer useStatus) {
		this.useStatus = useStatus;
	}

	public Date getUseTime() {
		return useTime;
	}

	public void setUseTime(Date useTime) {
		this.useTime = useTime;
	}
}
