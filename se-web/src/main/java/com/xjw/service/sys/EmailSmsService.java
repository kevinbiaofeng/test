package com.xjw.service.sys;

import com.xjw.base.service.BaseServcie;
import com.xjw.entity.po.sys.EmailSms;
import com.xjw.kzenum.sys.EmailSmsType;

public interface EmailSmsService extends BaseServcie<EmailSms>{

	/**
	 * 查询最新未使用的验证码 
	 * @param userId	用户ID
	 * @param type		短信类别 {@link EmailSmsType} 
	 */
	public EmailSms queryLatest(Long userId, Integer type);
}
