package com.xjw.service.order;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.xjw.base.service.BaseServcie;
import com.xjw.entity.form.order.DepositOrderForm;
import com.xjw.entity.po.order.DepositOrder;
import com.xjw.entity.vo.order.DepositOrderVo;
import com.xjw.utility.BizException;

@Service
public interface DepositOrderService extends BaseServcie<DepositOrder>{
	/**
	 * 银行转账 创建存款订单
	 * @param depositOrder
	 * @throws BizException
	 */
	public DepositOrder createBankTransferAccounts(DepositOrderVo vo) throws BizException;
	
	/**
	 * 第三方支付 创建存款订单
	 * @param depositOrder
	 * @throws BizException
	 */
	public DepositOrder createThirdPartyAccounts(DepositOrderVo vo) throws BizException;
	
	/**
	 * 审核订单
	 */
	public void updateOrderExamine(DepositOrderForm depositOrderForm) throws BizException;
	
	/**
	 * 根据第三方支付接口 返回值 修改订单状态 
	 * @param depositOrderForm
	 * @throws BizException
	 */
	public void thirdPartyResponse(String orderNo) throws BizException;
	
	
	/** 审核订单 */
	public void updateByAudit(Long id, Integer status, String remark) throws BizException;
	
	/** 查询代理的下属会员存款总额 */
	public BigDecimal selectAmountByAgent(Map<String, Object> params);
	
	/** 查询代理的下属会员有存款的人员，也叫活跃会员  **/
	public long selectAllCountByUser(Map<String, Object> params);
	
	/** 存款拒绝定时任务 **/
	public void updateDepositStatus()throws BizException;

}
