package com.xjw.service.message;

import java.util.List;

import com.xjw.base.service.BaseServcie;
import com.xjw.entity.po.message.Message;
import com.xjw.entity.po.user.User;
import com.xjw.utility.BizException;

public interface MessageService extends BaseServcie<Message>{
	
	/**
	 * 查询单个记录
	 * @param messageId		站内信ID
	 * @param receiveUser	收件人ID
	 */
	public Message queryOne(Long id, Long receiveUser);
	
	/**
	 * 保存站内信
	 * @param message	站内信	
	 * @param userList	收件人列表
	 */
	public void save(Message message, List<User> userList) throws BizException;
}
