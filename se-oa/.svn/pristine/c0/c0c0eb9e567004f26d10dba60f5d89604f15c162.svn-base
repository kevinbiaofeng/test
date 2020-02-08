package com.xjw.service.activity;


import java.util.List;

import org.springframework.stereotype.Service;

import com.xjw.base.service.BaseServcie;
import com.xjw.entity.po.activity.UserBankInfo;
import com.xjw.utility.BizException;

@Service
public interface UserBankInfoService extends BaseServcie<UserBankInfo>{
	/**
	 * 添加银行信息，并且更新默认选项
	 * @throws BizException
	 */
	public void saveBankInfo(UserBankInfo userBankInfo) throws BizException;
	
	/**
	 * 根据ID删除银行卡
	 * @throws BizException
	 */
	public void delById(String id) throws BizException;
	
	
	/**
	 * 根据银行类型 查询内部存款银行默认银行卡信息, 每种银行类型只有一条记录
	 * @throws BizException
	 */
	public UserBankInfo findUserBankInfoByBankType(String bankType) throws BizException;
	
	/**
	 * 出款银行列表
	 * @throws BizException
	 */
	public List<UserBankInfo> findOutUserBankInfoByBankType(String bankType, String _bankCard) throws BizException;
	
	/**
	 * 根据外网用户ID查询银行卡信息
	 * @throws BizException
	 */
	public UserBankInfo findUserBankInfoById(Long userId) throws BizException;
	
	/**
	 * 启用银行卡功能
	 * @return
	 * @throws BizException
	 */
	public void updateStart(String type, Integer bankType, String id) throws BizException;
}
