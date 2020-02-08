package com.xjw.kzenum.platform;

import com.xjw.kzenum.AbstractEnum;
/**
 * 转账类型
 */
public class TransferTypeEnum extends AbstractEnum {
	 public static final EnumBean INTO = new EnumBean("2", "转入"); //其他平台转主平台
	 public static final EnumBean OUT = new EnumBean("1", "转出"); //主平台转其他平台
}