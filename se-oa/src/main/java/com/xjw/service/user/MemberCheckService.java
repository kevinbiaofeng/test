package com.xjw.service.user;

import com.xjw.base.service.BaseServcie;
import com.xjw.entity.po.user.MemberCheck;
import com.xjw.utility.BizException;

public interface MemberCheckService extends BaseServcie<MemberCheck> {
	
	/**
	 * 查询用户个人信息校验情况，如果不存在，则创建并返回对象
	 * 	  注：事物必须以create开头才能正常提交数据
	 * @param id
	 * @return
	 * @throws BizException
	 */
	public MemberCheck createAndReturn(Long id) throws BizException;
	
}
