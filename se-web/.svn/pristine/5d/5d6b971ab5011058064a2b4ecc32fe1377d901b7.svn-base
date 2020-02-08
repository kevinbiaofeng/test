package com.xjw.service.user.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.BaseServcie;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.user.AccountIntegralDao;
import com.xjw.entity.po.user.AccountIntegral;
import com.xjw.service.user.UserAccountIntegralService;
import com.xjw.utility.BizException;

@Service
public class UserAccountIntegralServiceImpl extends BaseServiceImpl<AccountIntegral> implements UserAccountIntegralService, BaseServcie<AccountIntegral> {
  @Resource
  private AccountIntegralDao accountIntegralDao;
  
   /**
	 * 根据用户ID查询账户余额
	 * @return
	 */
	public AccountIntegral selectByUserId(Long userId){
		Map<String, Object> condition = new HashMap<String , Object>();
		condition.put("userId", userId);
		return this.selectOne(condition);
	}
	
	/**
	 * 根据用户ID增加签到积分
	 * @return
	 * @throws BizException 
	 */
	public void addIntegral(Long userId, Integer newIntegral) throws BizException{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("newIntegral", newIntegral);
		accountIntegralDao.addIntegral(params);
	}
	
	/**
	 * 根据用户ID减区积分
	 * @return
	 * @throws BizException 
	 */
	public String subtractIntegral(Long userId, Integer subtractIntegral) throws BizException{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		AccountIntegral ai = this.selectOne(params);
		if(ai.getIntegral() > 0){
			params.put("subtractIntegral", subtractIntegral);
			accountIntegralDao.subtractIntegral(params);
			return "100";
		}else{
			return "303";
		}
		
	}
  
  @Override
  public Class<AccountIntegral> getClazz() {
    return AccountIntegral.class;
  }

  @Override
  public BaseDaoImpl<AccountIntegral> baseDao() {
    return accountIntegralDao;
  }
}
