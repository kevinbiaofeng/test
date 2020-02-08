package com.xjw.kzenum.platform;

import com.xjw.kzenum.AbstractEnum;

public class FromFunctionEnum extends AbstractEnum{
	public static final EnumBean WEBSITE = new EnumBean("1", "网站户内转账");
  	public static final EnumBean HT = new EnumBean("2", "后台户内转账");
  	public static final EnumBean ZJTZ = new EnumBean("3", "资金调整");
  	public static final EnumBean FS = new EnumBean("4", "返水");
}
