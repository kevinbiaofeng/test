package com.xjw.service.message.impl;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.message.MessageDao;
import com.xjw.dao.message.MessageUserDao;
import com.xjw.entity.po.message.MessageUser;
import com.xjw.kzenum.sys.YesORNoEnum;
import com.xjw.service.message.MessageUserService;
import com.xjw.utility.BizException;

@Service
public class MessageUserServiceImpl extends BaseServiceImpl<MessageUser> implements MessageUserService {

	@Autowired
	private MessageDao messageDao;
	@Autowired
	private MessageUserDao messageUserDao;
	
	@Override
	public BaseDaoImpl<MessageUser> baseDao() {
		return messageUserDao;
	}
	
	public void updateByRead(Long messageId, Long receiveUser) throws BizException{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("messageId", messageId);
		params.put("receiveUser", receiveUser);
		params.put("readStatus", YesORNoEnum.YES.getCode());
		params.put("readTime", Calendar.getInstance().getTime());
		super.update(params);
	}
	
	@Override
	public MessageUser save(MessageUser t) throws BizException {
		super.save(t);
		messageDao.updateReceiveCount(t.getId());
		return t;
	}

	public void delete(Long messageId, Long receiveUser) throws BizException{		
		messageUserDao.delete(messageId, receiveUser);
		messageDao.updateReceiveCount(messageId);
	}
	
	@Override
	public Class<MessageUser> getClazz() {
		return MessageUser.class;
	}
}
