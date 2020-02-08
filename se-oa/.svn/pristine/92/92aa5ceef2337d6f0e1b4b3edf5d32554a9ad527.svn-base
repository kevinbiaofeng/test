package com.xjw.service.user.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.user.MemberCallcsDetailDao;
import com.xjw.entity.po.user.MemberCallcsDetail;
import com.xjw.service.user.MemberCallcsDetailService;

@Service
public class MemberCallcsDetailServiceImpl extends BaseServiceImpl<MemberCallcsDetail> implements MemberCallcsDetailService {
	@Resource
	private MemberCallcsDetailDao memberCallcsDetailDao;

	@Override
	public Class<MemberCallcsDetail> getClazz() {
		return MemberCallcsDetail.class;
	}

	@Override
	public BaseDaoImpl<MemberCallcsDetail> baseDao() {
		return memberCallcsDetailDao;
	}
}
