package com.xjw.service.order.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.BaseServcie;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.order.MemberMoneyChangeDao;
import com.xjw.entity.po.order.MemberMoneyChange;
import com.xjw.service.order.MemberMoneyChangeService;

@Service
public class MemberMoneyChangeServiceImpl extends BaseServiceImpl<MemberMoneyChange> implements MemberMoneyChangeService, BaseServcie<MemberMoneyChange> {
	@Resource
	private MemberMoneyChangeDao memberMoneyChangeDao;
	
	@Override
	public Class<MemberMoneyChange> getClazz() {
		return MemberMoneyChange.class;
	}

	@Override
	public BaseDaoImpl<MemberMoneyChange> baseDao() {
		return memberMoneyChangeDao;
	}

}
