package com.xjw.service.message.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.message.MessageDao;
import com.xjw.dao.message.MessageUserDao;
import com.xjw.entity.po.message.Message;
import com.xjw.entity.po.message.MessageUser;
import com.xjw.entity.po.user.User;
import com.xjw.kzenum.sys.YesORNoEnum;
import com.xjw.service.message.MessageService;
import com.xjw.utility.BizException;

@Service
public class MessageServiceImpl extends BaseServiceImpl<Message> implements MessageService {
	
	@Autowired
	private MessageDao messageDao;
	@Autowired
	private MessageUserDao messageUserDao;
	
	public void save(Message message, List<User> userList) throws BizException{
		super.save(message);
		
		if(null != userList){
			for(User user : userList){
				MessageUser mu = new MessageUser();
				mu.setMessageId(message.getId());
				mu.setReceiveUser(user.getId());
				mu.setReceiveName(user.getLoginName());
				mu.setReadStatus(Integer.valueOf(YesORNoEnum.NO.getCode()));
				messageUserDao.save(mu);
			}
		}
	}
	
	public Message queryOne(Long id, Long receiveUser){
		if(null == id || null == receiveUser){
			return null;
		}
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		params.put("receiveUser", receiveUser);
		return super.selectOne(params);
		
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
