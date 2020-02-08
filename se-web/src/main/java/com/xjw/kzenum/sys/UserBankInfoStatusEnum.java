package com.xjw.kzenum.sys;

import com.xjw.kzenum.AbstractEnum;

public class UserBankInfoStatusEnum extends AbstractEnum{
  public static final EnumBean START = new EnumBean("1", "启用");
  public static final EnumBean STOP = new EnumBean("2", "禁用");
  public static final EnumBean DEL = new EnumBean("3", "删除");
}