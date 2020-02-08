package com.xjw.service.platform;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.xjw.base.service.BaseServcie;
import com.xjw.entity.po.platform.Cathectic;
import com.xjw.entity.po.platform.UserRebate;

@Service
public interface CathecticService extends BaseServcie<Cathectic>{
	//今日投注总额
//	public BigDecimal selectSumBetAmount(Map<String, Object> params);
	//查询汇总金额
	public List<UserRebate> selectSumAmount(Map<String, Object> params);
}
