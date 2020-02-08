package com.xjw.service.sys;

import org.springframework.stereotype.Service;

import com.xjw.entity.po.user.User;

@Service
public interface CookieDataService {
	/**
	 * 生成用户cookie数据, 并加密
	 * @return
	 */
	public String initUserCookieData(User user) throws Exception;
}
