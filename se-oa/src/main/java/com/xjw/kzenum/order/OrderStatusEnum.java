package com.xjw.kzenum.order;

import com.xjw.kzenum.AbstractEnum;

public class OrderStatusEnum extends AbstractEnum {
  public static final EnumBean DRAFT = new EnumBean("1", "未到账");
  public static final EnumBean SUCCESS = new EnumBean("2", "成功");
  public static final EnumBean FAIL = new EnumBean("3", "失败");
}