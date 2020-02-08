package com.xjw.service.message.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.message.MessageDao;
import com.xjw.dao.message.MessageUserDao;
import com.xjw.entity.po.message.MessageUser;
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
	
	@Override
	public MessageUser save(MessageUser t) throws BizException {
		super.save(t);
		messageDao.updateReceiveCount(t.getId());
		return t;
	}

	public void deleteById(Long id) throws BizException{
		messageUserDao.deleteById(id);
		messageDao.updateReceiveCount(id);
	}
	
	@Override
	public Class<MessageUser> getClazz() {
		return MessageUser.class;
	}
}
