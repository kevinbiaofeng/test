package com.xjw.service.sys.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.sys.EmailSmsDao;
import com.xjw.entity.po.sys.EmailSms;
import com.xjw.service.sys.EmailSmsService;

@Service
public class EmailSmsServiceImpl extends BaseServiceImpl<EmailSms> implements EmailSmsService{

	@Autowired
	private EmailSmsDao emailSmsDao;
	
	@Override
	public BaseDaoImpl<EmailSms> baseDao() {
		return emailSmsDao;
	}

	@Override
	public Class<EmailSms> getClazz() {
		return EmailSms.class;
	}
}
