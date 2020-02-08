package com.xjw.dao.sys;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.entity.po.sys.EmailSms;

@Repository
public class EmailSmsDao extends BaseDaoImpl<EmailSms>{

	public EmailSms queryLatest(Long userId, Integer type){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("type", type);
		return super.getSqlSession().selectOne("EmailSms.queryLatest", params);
	}
}
