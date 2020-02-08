package com.xjw.dao.platform;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.entity.po.platform.PlatformWallet;

@Repository
public class PlatformWalletDao extends BaseDaoImpl<PlatformWallet>{

	public List<PlatformWallet> selectAllGroupByAgent(Map<String, Object> params){
		return this.getSqlSession().selectList("PlatformWallet.selectAllGroupByAgent", params);
	}
	
	public Integer deleteAll(){
		return this.getSqlSession().delete("PlatformWallet.deleteAll");
	}
}
