package com.xjw.kzenum.notice;

import com.xjw.kzenum.AbstractEnum;

public class NoticeTypeEnum extends AbstractEnum {
  public static final EnumBean SYS = new EnumBean("1", "系统消息");

  public static final EnumBean USER = new EnumBean("2", "用户消息");
}