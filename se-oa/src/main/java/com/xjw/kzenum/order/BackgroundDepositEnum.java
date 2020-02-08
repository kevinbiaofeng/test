package com.xjw.kzenum.order;

import com.xjw.kzenum.AbstractEnum;

public class BackgroundDepositEnum extends AbstractEnum{
	public static final EnumBean ONLINE_BANKING_PAYMENT = new EnumBean("1", "网银转账");
	public static final EnumBean WX_PAYMENT = new EnumBean("10","微信转账");
	public static final EnumBean ZFB_PAYMENT = new EnumBean("11","支付宝转账");
}
