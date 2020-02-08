package com.xjw.service.user;

import org.springframework.stereotype.Service;

import com.xjw.base.service.BaseServcie;
import com.xjw.entity.po.user.AccountIntegral;
import com.xjw.utility.BizException;

@Service
public interface UserAccountIntegralService extends BaseServcie<AccountIntegral>{
	/**
	 * 根据用户ID查询账户余额
	 * @return
	 */
	public AccountIntegral selectByUserId(Long userId);
	/**
	 * 在原积分上添加积分
	 */
	public void addIntegral(Long userId, Integer newIntegral) throws BizException;
	
	/**
	 * 在原积分上减去积分
	 */
	public String subtractIntegral(Long userId, Integer subtractIntegral) throws BizException;
}
