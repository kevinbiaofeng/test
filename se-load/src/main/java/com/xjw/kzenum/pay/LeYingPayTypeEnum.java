package com.xjw.kzenum.pay;

import com.xjw.kzenum.AbstractEnum;

public class LeYingPayTypeEnum extends AbstractEnum{
	public static final EnumBean ALL = new EnumBean("ALL", "所有付款方式");
	public static final EnumBean BANK_B2C = new EnumBean("BANK_B2C", "网银B2C");
	public static final EnumBean WX = new EnumBean("WX", "微信");
}