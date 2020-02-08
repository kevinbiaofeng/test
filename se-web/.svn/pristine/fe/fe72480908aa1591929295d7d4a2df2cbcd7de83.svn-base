package com.xjw.service.sys;


import java.util.List;

import org.springframework.stereotype.Service;
import com.xjw.base.service.BaseServcie;
import com.xjw.entity.po.sys.UserBankInfo;
import com.xjw.kzenum.sys.UserBankInfoStatusEnum;
import com.xjw.kzenum.sys.UserBankInfoTypeEnum;
import com.xjw.utility.BizException;

@Service
public interface UserBankInfoService extends BaseServcie<UserBankInfo>{
	/**
	 * 根据银行类型 查询内部存款银行默认银行卡信息, 每种银行类型只有一条记录
	 * @throws BizException
	 */
	public UserBankInfo getBankInfoByBankType(String bankType) throws BizException;
	
	/**
	 * 查询用户绑定的银行卡
	 * @param userId   	必填		用户ID
	 * @param type		必填		用户类别 {@link UserBankInfoTypeEnum}}
	 * @param status 	选填		银行卡状态 {@link UserBankInfoStatusEnum}
	 */
	public List<UserBankInfo> queryList(Long userId, Integer type, Integer status) throws BizException;
}
