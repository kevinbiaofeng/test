package com.xjw.service.order;

import java.math.BigDecimal;
import java.util.Map;

import com.xjw.base.service.BaseServcie;
import com.xjw.entity.form.order.DepositOrderForm;
import com.xjw.entity.form.pay.GuoFuBaoRespForm;
import com.xjw.entity.form.pay.LeYingForm;
import com.xjw.entity.form.pay.ShbScanCallbackForm;
import com.xjw.entity.form.pay.TongHuiWechatForm;
import com.xjw.entity.form.pay.YinBaoForm;
import com.xjw.entity.po.order.DepositOrder;
import com.xjw.entity.vo.order.YSResponseVo;
import com.xjw.utility.BizException;

public interface DepositOrderService extends BaseServcie<DepositOrder>{
	
	/** 查询存款总额 */
	public BigDecimal selectSumAmount(Map<String, Object> params);
	
	/** 创建存款订单 */
	public DepositOrder createOrder(Long userId, DepositOrderForm depositOrderForm) throws Exception;
	
	/**
	 * 创建银行转账订单
	 * @param vo
	 * @return
	 * @throws BizException
	 */
	public DepositOrder createTransferBankOrder(DepositOrderForm depositOrderForm, Long userId, String tradeMode) throws Exception;
	
	/**
	 * 国付宝回调接口
	 */
	public void callbackByGuoFuBao(GuoFuBaoRespForm form) throws Exception;
	
	/**
	 * 通汇微信回调接口
	 */
	public void callbackByTongHui(TongHuiWechatForm form) throws Exception;
	
	/**
	 * 银宝回调接口 
	 */
	public void callbackByYinBao(YinBaoForm form) throws Exception;
	
	/**
	 * 乐盈回调接口 
	 */
	public void callbackByLeYing(LeYingForm form) throws Exception;
	
	/** 速汇宝扫码<微信、支付宝>回调接口 */
	public void callbackByShbScan(ShbScanCallbackForm form) throws Exception;
	
	/**
	 * 云盛-在线支付回调接口
	 */
	public void callbackByYS(YSResponseVo vo) throws Exception;
}
