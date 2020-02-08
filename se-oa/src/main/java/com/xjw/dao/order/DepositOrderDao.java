package com.xjw.dao.order;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.entity.po.order.DepositOrder;
import com.xjw.entity.vo.data.SummaryDepositVo;

@Repository
public class DepositOrderDao extends BaseDaoImpl<DepositOrder>{

	public BigDecimal selectSumAmount(Map<String, Object> params){
		return super.getSqlSession().selectOne("DepositOrder.selectSumAmount", params);
	}
	
	public List<SummaryDepositVo> selectSumAmountGroupByTradeMode(Map<String, Object> params){
		return super.getSqlSession().selectList("DepositOrder.selectSumAmountGroupByTradeMode", params);
	}
	
	/** 查询代理的下属会员存款总额 */
	public BigDecimal selectAmountByAgent(Map<String, Object> params){
		return super.getSqlSession().selectOne("DepositOrder.selectAmountByAgent", params);
	}
	
	/** 查询代理的下属会员存款总额 */
	public long selectAllCountByUser(Map<String, Object> params){
		return super.getSqlSession().selectOne("DepositOrder.selectAllCountByUser", params);
	}
	
	/** 存款订单拒绝功能, 会员存款5个小时转账未到系统账户的订单,修改状态  */
	public void updateStatus(){
		super.getSqlSession().update("DepositOrder.updateStatus");
	}
	
}
