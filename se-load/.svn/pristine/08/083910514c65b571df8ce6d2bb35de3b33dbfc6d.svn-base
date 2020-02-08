package com.xjw.service.sys.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.BaseServcie;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.sys.UserBankInfoDao;
import com.xjw.entity.po.sys.UserBankInfo;
import com.xjw.kzenum.sys.UserBankInfoStatusEnum;
import com.xjw.kzenum.sys.UserBankInfoTypeEnum;
import com.xjw.kzenum.sys.YesORNoEnum;
import com.xjw.service.sys.UserBankInfoService;
import com.xjw.utility.BizException;

@Service
public class UserBankInfoServiceImpl extends BaseServiceImpl<UserBankInfo> implements UserBankInfoService, BaseServcie<UserBankInfo> {
	@Resource
	private UserBankInfoDao userBankInfoDao;

	public UserBankInfo getBankInfoByBankType(String bankType) throws BizException {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("type", UserBankInfoTypeEnum.INSIDE_DEPOSIT.getCode());
		condition.put("searchBankType", bankType);
		condition.put("isDefault", YesORNoEnum.YES.getCode());
		condition.put("searchStauts", UserBankInfoStatusEnum.START.getCode());
		return this.selectOne(condition);
	}
	
	public List<UserBankInfo> queryList(Long userId, Integer type, Integer status) throws BizException {
		if(null == userId || userId <= 0){
			throw new BizException("请输入用户ID");
		}else if(null == type || null == UserBankInfoTypeEnum.getEnumByCode(UserBankInfoTypeEnum.class, String.valueOf(type))){
			throw new BizException("请输入正确的用户类型");
		}else if(null != type && null == UserBankInfoTypeEnum.getEnumByCode(UserBankInfoStatusEnum.class, String.valueOf(type))){
			throw new BizException("请输入正确的银行卡状态");
		}
		
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("userId", userId);
		condition.put("type", type);
		condition.put("status", status);
		return this.selectAll(condition);
	}
	
	@Override
	public Class<UserBankInfo> getClazz() {
		return UserBankInfo.class;
	}

	@Override
	public BaseDaoImpl<UserBankInfo> baseDao() {
		return userBankInfoDao;
	}
}
