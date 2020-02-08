package com.xjw.kzenum.sys;

import com.xjw.kzenum.AbstractEnum;

public class PageSizeEnum extends AbstractEnum{
  public static final EnumBean DEFAULT = new EnumBean("15", "15条");
  public static final EnumBean FIFTY = new EnumBean("50", "50条");
  public static final EnumBean HUNDRED = new EnumBean("100", "100条");
}
