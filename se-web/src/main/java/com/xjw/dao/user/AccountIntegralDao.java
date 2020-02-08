package com.xjw.dao.user;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.entity.po.user.AccountIntegral;
import com.xjw.utility.BizException;

@Repository
public class AccountIntegralDao extends BaseDaoImpl<AccountIntegral>{
	public int addIntegral(Map<String, Object> params) throws BizException {
		return getSqlSession().update("AccountIntegral.addIntegral", params);
	}
	
	public int subtractIntegral(Map<String, Object> params) throws BizException {
		return getSqlSession().update("AccountIntegral.subtractIntegral", params);
	}
}
