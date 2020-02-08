package com.xjw.service.platform;

import java.util.List;
import java.util.Map;

import com.xjw.base.service.BaseServcie;
import com.xjw.entity.po.platform.PlatformWallet;

public interface PlatformWalletService extends BaseServcie<PlatformWallet>{
	
	public List<PlatformWallet> selectAllGroupByAgent(Map<String, Object> params);
	
	public Integer deleteAll();
}
