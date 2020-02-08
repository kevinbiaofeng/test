package com.xjw.service.user.impl;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.user.MemberCheckDao;
import com.xjw.entity.po.user.MemberCheck;
import com.xjw.kzenum.sys.YesORNoEnum;
import com.xjw.service.user.MemberCheckService;
import com.xjw.utility.BizException;

@Service
public class MemberCheckServiceImpl extends BaseServiceImpl<MemberCheck> implements MemberCheckService {
	private static Logger logger = LoggerFactory.getLogger(MemberCheckService.class);
	
	@Autowired
	private MemberCheckDao memberCheckDao;
	

	public MemberCheck createAndReturn(Long userId) throws BizException {
		MemberCheck memberCheck = memberCheckDao.queryByUserId(userId);
		if(null == memberCheck){
			memberCheck = new MemberCheck();
			memberCheck.setUserId(userId);
			memberCheck.setEmailFlag(Integer.valueOf(YesORNoEnum.NO.getCode()));
			memberCheck.setPhoneFlag(Integer.valueOf(YesORNoEnum.NO.getCode()));
			memberCheck.setIdCardFlag(Integer.valueOf(YesORNoEnum.NO.getCode()));
			memberCheck.setBankCardFlag(Integer.valueOf(YesORNoEnum.NO.getCode()));
			this.save(memberCheck);
		}
		
		return memberCheck;
	}
	
	@Override
	public BaseDaoImpl<MemberCheck> baseDao() {
		return memberCheckDao;
	}

	@Override
	public Class<MemberCheck> getClazz() {
		return MemberCheck.class;
	}
}
