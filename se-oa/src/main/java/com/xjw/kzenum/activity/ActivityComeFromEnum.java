package com.xjw.kzenum.activity;

import com.xjw.entity.po.activity.Activity;
import com.xjw.kzenum.AbstractEnum;

/**
 *	活动类型 {@link Activity.comeFrom}
 *	
 */
public class ActivityComeFromEnum extends AbstractEnum{
	 public static final EnumBean web = new EnumBean("1", "线上活动");
	 public static final EnumBean xjw = new EnumBean("2", "线下活动");
	 
}
