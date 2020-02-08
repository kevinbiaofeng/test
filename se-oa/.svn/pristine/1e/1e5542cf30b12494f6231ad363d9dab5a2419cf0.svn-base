package com.xjw.service.activity.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.activity.UserBankInfoDao;
import com.xjw.entity.po.activity.UserBankInfo;
import com.xjw.kzenum.activity.UserBankInfoStatusEnum;
import com.xjw.kzenum.activity.UserBankInfoTypeEnum;
import com.xjw.kzenum.sys.YesORNoEnum;
import com.xjw.service.activity.UserBankInfoService;
import com.xjw.utility.BizException;
import com.xjw.utility.CurrentUserHolder;

@Service
public class UserBankInfoServiceImpl extends BaseServiceImpl<UserBankInfo> implements UserBankInfoService {
	@Resource
	private UserBankInfoDao userBankInfoDao;

	public void saveBankInfo(UserBankInfo userBankInfo) throws BizException {
		userBankInfo.setIsDefault(Integer.valueOf(YesORNoEnum.YES.getCode()));
		userBankInfo.setStatus(Integer.valueOf(UserBankInfoStatusEnum.STOP.getCode()));
		userBankInfo = this.save(userBankInfo);
	}

	public void delById(String id) throws BizException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("update_user", CurrentUserHolder.getUserId());
		map.put("update_time", new Date());
		map.put("status", UserBankInfoStatusEnum.DEL.getCode());
		this.deleteOne(map);
	}

	public UserBankInfo findUserBankInfoByBankType(String bankType) throws BizException {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("type", UserBankInfoTypeEnum.INSIDE_DEPOSIT.getCode());
		condition.put("searchBankType", bankType);
		condition.put("isDefault", YesORNoEnum.YES.getCode());
		condition.put("searchStauts", UserBankInfoStatusEnum.START.getCode());
		return this.selectOne(condition);
	}
	
	public List<UserBankInfo> findOutUserBankInfoByBankType(String bankType, String _bankCard) throws BizException{
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("type", UserBankInfoTypeEnum.INSIDE_WITHDRAWAL.getCode());
		condition.put("bankType", bankType);
		condition.put("isDefault", YesORNoEnum.YES.getCode());
		condition.put("status", UserBankInfoStatusEnum.START.getCode());
		if(StringUtils.isNotBlank(_bankCard)){
			condition.put("bankCardNo", _bankCard);
		}
		return this.selectAll(condition);
	}
	
	public void updateStart(String type, Integer bankType, String id) throws BizException{
		Map<String, Object> params = new HashMap<String, Object>();
		if(type.equals(UserBankInfoTypeEnum.INSIDE_DEPOSIT.getCode())){
			//存款银行卡每种类别只能启用一张银行卡, 停用所有的该类别银行卡
			params.put("status", UserBankInfoStatusEnum.STOP.getCode()); //修改条件
			//修改条件
			params.put("type", UserBankInfoTypeEnum.INSIDE_DEPOSIT.getCode());
			params.put("searchBankType", bankType);
			params.put("searchStauts", UserBankInfoStatusEnum.START.getCode());
			this.update(params);
		}
		
		params.clear();
		params.put("status", UserBankInfoStatusEnum.START.getCode());
		params.put("id", id);
		this.update(params);
	}
	
	public UserBankInfo findUserBankInfoById(Long userId) throws BizException{
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("type", UserBankInfoTypeEnum.OUTSIDE.getCode());
		condition.put("userId", userId);
		return this.selectOne(condition);
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
