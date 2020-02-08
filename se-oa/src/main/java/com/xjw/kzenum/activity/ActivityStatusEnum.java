package com.xjw.kzenum.activity;

import com.xjw.kzenum.AbstractEnum;

public class ActivityStatusEnum extends AbstractEnum{
  public static final EnumBean DRAFT = new EnumBean("1", "草稿");
  public static final EnumBean START = new EnumBean("2", "启动");
  public static final EnumBean STOP = new EnumBean("3", "暂停");
  public static final EnumBean DOWN = new EnumBean("4", "下线");
  public static final EnumBean DEL = new EnumBean("5", "删除");
}