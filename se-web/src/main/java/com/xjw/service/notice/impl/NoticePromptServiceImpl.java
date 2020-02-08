package com.xjw.service.notice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.BaseServcie;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.notice.NoticePromptDao;
import com.xjw.entity.po.notice.NoticePrompt;
import com.xjw.service.notice.NoticePromptService;

@Service
public class NoticePromptServiceImpl extends BaseServiceImpl<NoticePrompt> implements NoticePromptService, BaseServcie<NoticePrompt> {
	@Autowired
	private NoticePromptDao noticePromptDao;

	@Override
	public BaseDaoImpl<NoticePrompt> baseDao() {
		return noticePromptDao;
	}

	@Override
	public Class<NoticePrompt> getClazz() {
		return NoticePrompt.class;
	}

}