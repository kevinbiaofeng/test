package com.xjw.dao.message;

import org.springframework.stereotype.Repository;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.entity.po.message.Message;
import com.xjw.utility.BizException;

@Repository
public class MessageDao extends BaseDaoImpl<Message>{
	
	public void updateReceiveCount(Long id) throws BizException{
		super.getSqlSession().delete("Message.updateReceiveCount", id);
	}
	
}
