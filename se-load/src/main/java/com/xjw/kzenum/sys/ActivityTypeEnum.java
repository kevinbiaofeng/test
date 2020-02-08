package com.xjw.kzenum.sys;

import com.xjw.entity.po.activity.Activity;
import com.xjw.kzenum.AbstractEnum;

/**
 *	活动类别 {@link Activity.type}
 *	
 */
public class ActivityTypeEnum extends AbstractEnum{
	 public static final EnumBean SPORT = new EnumBean("1", "体育游戏 ");
	 public static final EnumBean ELEC = new EnumBean("2", "电子游戏");
	 public static final EnumBean CHESS = new EnumBean("3", "棋牌游戏");
	 public static final EnumBean FISH = new EnumBean("4", "捕鱼游戏");
	 public static final EnumBean PERSON = new EnumBean("5", "真人视讯");
	 public static final EnumBean OTHER = new EnumBean("6", "其它");
	 
}
