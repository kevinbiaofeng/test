package com.xjw.service.user;

import com.xjw.base.service.BaseServcie;
import com.xjw.entity.po.user.Sign;
import com.xjw.utility.BizException;

public interface SignService extends BaseServcie<Sign> {
	
	/**
	 * 会员今日签到
	 * @param userId
	 * @return
	 */
	public String modifySignToday(Long userId) throws BizException;
}
