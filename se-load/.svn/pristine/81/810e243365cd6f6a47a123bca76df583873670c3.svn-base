package com.xjw.dao.message;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.entity.po.message.MessageUser;

@Repository
public class MessageUserDao extends BaseDaoImpl<MessageUser>{

	public void save(MessageUser messageUser){
		getSqlSession().insert("MessageUser.save", messageUser);
	}
	
	public void delete(Long messageId, Long receiveUser){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("messageId", messageId);
		params.put("receiveUser", receiveUser);
		
		super.getSqlSession().delete("MessageUser.delete", params);
	}
	
}
