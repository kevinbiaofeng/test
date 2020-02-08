package com.xjw.dao.order;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.entity.po.order.DepositOrder;

@Repository
public class DepositOrderDao extends BaseDaoImpl<DepositOrder>{
	public DepositOrder queryByOrderNo(String orderNo) {
		return getSqlSession().selectOne("DepositOrder.queryByOrderNo", orderNo);
	}
	
	public BigDecimal selectSumAmount(Map<String, Object> params) {
		return getSqlSession().selectOne("DepositOrder.selectSumAmount", params);
	}
}
