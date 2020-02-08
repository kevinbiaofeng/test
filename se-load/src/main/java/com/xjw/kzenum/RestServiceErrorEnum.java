package com.xjw.kzenum;



public class RestServiceErrorEnum extends AbstractEnum{
	//JSON 数据转换 BEAN 异常
	public static final EnumBean FORMAT = new EnumBean("1", "Request parameter error.");
	//JSON 数据转换 BEAN 异常
	public static final EnumBean TOKEN = new EnumBean("4", "The token is error.");
	//传递的数据找不到对象
	public static final EnumBean NOT_FIND = new EnumBean("2", " not find.");
	//服务器没有响应，只有在token错误时
	public static final EnumBean NO_RESPONSE = new EnumBean("3", "Server no response.");
	//账户资金不足
	public static final EnumBean INSUFFICIENT_FUNDS = new EnumBean("5", "Insufficient account balance.");
}
