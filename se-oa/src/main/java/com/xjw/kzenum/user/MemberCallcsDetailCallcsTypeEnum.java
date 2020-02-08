package com.xjw.kzenum.user;

import com.xjw.kzenum.AbstractEnum;

public class MemberCallcsDetailCallcsTypeEnum extends AbstractEnum {
	public static final EnumBean SECOND_CALL = new EnumBean("1", "需二次回访");
	public static final EnumBean NO_NEED_CALL = new EnumBean("2", "无需回访");
	public static final EnumBean CLOSE_MEMBER = new EnumBean("3", "关闭用户");
	public static final EnumBean INVALID_PHONE = new EnumBean("4", "无效号码");
}