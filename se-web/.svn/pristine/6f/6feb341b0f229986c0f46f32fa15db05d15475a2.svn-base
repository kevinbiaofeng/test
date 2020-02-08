package com.xjw.service.message;

import com.xjw.base.service.BaseServcie;
import com.xjw.entity.po.message.MessageUser;
import com.xjw.utility.BizException;

public interface MessageUserService extends BaseServcie<MessageUser>{
	
	/**
	 * 收件人已阅读
	 * @param messageId	 	 站内信ID
	 * @param receiveUser	收件人ID
	 */
	public void updateByRead(Long messageId, Long receiveUser) throws BizException;
	
	/**
	 * 收件人删除站内信 
	 * @param messageId		站内信ID
	 * @param receiveUser	收件人ID
	 */
	public void delete(Long messageId, Long receiveUser) throws BizException;
	
}
