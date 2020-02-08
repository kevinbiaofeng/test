package com.xjw.dao.message;

import org.springframework.stereotype.Repository;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.entity.po.message.MessageUser;
import com.xjw.utility.BizException;

@Repository
public class MessageUserDao extends BaseDaoImpl<MessageUser>{

	public void deleteById(Long id) throws BizException{
		super.getSqlSession().delete("MessageUser.deleteById", id);
	}
	
	public void deleteByMessageId(Long messageId) throws BizException{
		super.getSqlSession().delete("MessageUser.deleteByMessageId", messageId);
	}
}
