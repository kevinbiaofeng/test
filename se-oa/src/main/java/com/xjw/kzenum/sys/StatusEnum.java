package com.xjw.kzenum.sys;

import com.xjw.kzenum.AbstractEnum;

public class StatusEnum extends AbstractEnum{
  public static final EnumBean DEFAULT = new EnumBean("1", "正常");
  public static final EnumBean LOCK = new EnumBean("2", "冻结");
  public static final EnumBean DEL = new EnumBean("3", "关闭");
}
