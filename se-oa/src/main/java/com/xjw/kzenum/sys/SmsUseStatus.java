package com.xjw.kzenum.sys;

import com.xjw.kzenum.AbstractEnum;

public class SmsUseStatus extends AbstractEnum{
	 public static final EnumBean UN_USE = new EnumBean("0", "未使用");
	 public static final EnumBean HAS_USE = new EnumBean("1", "已使用");
	 public static final EnumBean EXPIRE = new EnumBean("2", "已过期");
}
