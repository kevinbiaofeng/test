package com.xjw.kzenum.notice;

import com.xjw.kzenum.AbstractEnum;

public class NoticeCodeEnum extends AbstractEnum {
	// 存款订单在线支付
	public static final EnumBean DEPOSIT_ONLINE_PAYMENT = new EnumBean("DEPOSIT_ONLINE_PAYMENT", "存款订单在线支付");
	// 存款订单网银转账
	public static final EnumBean DEPOSIT_ONLINE_BANKING_PAYMENT = new EnumBean("DEPOSIT_ONLINE_BANKING_PAYMENT", "存款订单网银转账");
	//提款订单风控审批
	public static final EnumBean WITHDRAWAL_FK_APPROVE = new EnumBean("WITHDRAWAL_FK_APPROVE", "提款订单风控审批");
	//提款订单财务审批
	public static final EnumBean WITHDRAWAL_CW_APPROVE = new EnumBean("WITHDRAWAL_CW_APPROVE", "提款订单财务审批");
}