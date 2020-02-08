package com.xjw.service.message.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.message.MessageDao;
import com.xjw.dao.message.MessageUserDao;
import com.xjw.entity.po.message.Message;
import com.xjw.service.message.MessageService;
import com.xjw.utility.BizException;

@Service
public class MessageServiceImpl extends BaseServiceImpl<Message> implements MessageService {
	
	@Autowired
	private MessageDao messageDao;
	@Autowired
	private MessageUserDao messageUserDao;
	
	
	public void deleteById(Long id) throws BizException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		super.deleteOne(params);
		
		messageUserDao.deleteByMessageId(id);
	}
	
	@Override
	public BaseDaoImpl<Message> baseDao() {
		return messageDao;
	}

	@Override
	public Class<Message> getClazz() {
		return Message.class;
	}
}
