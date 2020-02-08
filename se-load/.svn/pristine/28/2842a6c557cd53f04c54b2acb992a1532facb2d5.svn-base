package com.xjw.service.sys.impl;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.xjw.entity.po.user.User;
import com.xjw.service.sys.CookieDataService;

@Service
public class CookieDataServiceImpl implements CookieDataService{
	
	public String initUserCookieData(User user) throws Exception{
		return JSON.toJSONString(user);
	}
}
