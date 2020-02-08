package com.xjw.dao.message;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.entity.po.message.Message;
import com.xjw.utility.BizException;

@Repository
public class MessageDao extends BaseDaoImpl<Message>{
	
	public Message queryOne(Map<String, Object> params) throws BizException{
		return super.getSqlSession().selectOne("Message.queryOne", params);
	}
	
	public void updateReceiveCount(Long id) throws BizException{
		super.getSqlSession().delete("Message.updateReceiveCount", id);
	}
	
}
