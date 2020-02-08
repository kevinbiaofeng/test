package com.xjw.kzenum.user;

import com.xjw.kzenum.AbstractEnum;
import com.xjw.kzenum.AbstractEnum.EnumBean;

public class MemberVIPTypeEnum extends AbstractEnum{
	public static final EnumBean ORDINARY = new EnumBean("1", "普通会员");
	public static final EnumBean VIP2 = new EnumBean("2", "县令");
	public static final EnumBean VIP3 = new EnumBean("3", "尚书");
	public static final EnumBean VIP4 = new EnumBean("4", "丞相");
	public static final EnumBean VIP5 = new EnumBean("5", "天子");
}