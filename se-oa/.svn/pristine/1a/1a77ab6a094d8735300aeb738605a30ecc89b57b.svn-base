package com.xjw.service.user.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.user.MemberRemarkDao;
import com.xjw.entity.po.user.MemberRemark;
import com.xjw.service.user.MemberRemarkService;

@Service
public class MemberRemarkServiceImpl extends BaseServiceImpl<MemberRemark> implements MemberRemarkService {
	@Resource
	private MemberRemarkDao memberRemarkDao;

	@Override
	public Class<MemberRemark> getClazz() {
		return MemberRemark.class;
	}

	@Override
	public BaseDaoImpl<MemberRemark> baseDao() {
		return memberRemarkDao;
	}

}
