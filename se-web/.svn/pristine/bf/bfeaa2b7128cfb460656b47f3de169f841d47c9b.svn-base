package com.xjw.service.order;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.xjw.base.service.BaseServcie;
import com.xjw.entity.po.order.WithdrawalOrder;
import com.xjw.entity.po.user.User;

@Service
public interface WithdrawalOrderService extends BaseServcie<WithdrawalOrder>{
	
	/**
	 * 创建提款订单
	 * @param user			必填		用户
	 * @param userBankId	必填		用户绑定银行卡ID
	 * @param amount		必填		提款基恩
	 * @param remark		选填		备注
	 */
	public WithdrawalOrder createOrder(User user, Long userBankId, BigDecimal amount, String remark) throws Exception;
}
