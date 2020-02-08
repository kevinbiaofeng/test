package com.xjw.service.message;

import com.xjw.base.service.BaseServcie;
import com.xjw.entity.po.message.MessageUser;
import com.xjw.utility.BizException;

public interface MessageUserService extends BaseServcie<MessageUser>{
	public void deleteById(Long id) throws BizException;
}
