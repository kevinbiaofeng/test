package com.xjw.dao.order;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.entity.po.order.WithdrawalFinance;
import com.xjw.entity.po.order.WithdrawalOrder;
import com.xjw.entity.po.order.WithdrawalRisk;
import com.xjw.entity.vo.order.DrawalCount;

@Repository
public class WithdrawalOrderDao extends BaseDaoImpl<WithdrawalOrder>{
	
	public BigDecimal selectSumAmount(Map<String, Object> params){
		return super.getSqlSession().selectOne("WithdrawalOrder.selectSumAmount", params);
	}
	
	/** 查询代理的下属会员提款总额 */
	public BigDecimal selectAmountByAgent(Map<String, Object> params){
		return super.getSqlSession().selectOne("WithdrawalOrder.selectAmountByAgent", params);
	}
	
	/** 查询时间段内，提款订单超过5分钟审核的单据  **/
	public List<WithdrawalFinance> selectCountWithdrawalFinance(Map<String, Object> params){
		return super.getSqlSession().selectList("WithdrawalOrder.selectCountWithdrawalFinance", params);
	}
	
	/** 查询时间段内，提款订单超过5分钟审核的单据  **/
	public List<WithdrawalRisk> selectCountWithdrawalRisk(Map<String, Object> params){
		return super.getSqlSession().selectList("WithdrawalOrder.selectCountWithdrawalRisk", params);
	}
	
	/**根据当前用户查询提款记录是否有成功过的记录 **/
	public List<DrawalCount> getDrawalCount(Map<String, Object> params){
		return super.getSqlSession().selectList("WithdrawalOrder.selectDrawalCount", params);
	}
}
