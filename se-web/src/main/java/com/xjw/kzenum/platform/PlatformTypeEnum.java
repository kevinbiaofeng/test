package com.xjw.kzenum.platform;

import com.xjw.kzenum.AbstractEnum;

/**
 * 平台类型
 */
public class PlatformTypeEnum extends AbstractEnum {
    public static final EnumBean MAIN = new EnumBean("0", "主平台");
    public static final EnumBean AG_GJ = new EnumBean("1", "AG国际厅");
    public static final EnumBean AG_JS = new EnumBean("2", "AG急速版");
    public static final EnumBean PT = new EnumBean("3", "PT");
    public static final EnumBean MG = new EnumBean("4", "MG");
    public static final EnumBean SB = new EnumBean("5", "沙巴体育");
    public static final EnumBean BY = new EnumBean("6", "捕鱼王");
    public static final EnumBean QP = new EnumBean("7", "棋牌");
    /******* 电子游戏 ********/
    
    /** GM系列 */
    public static final EnumBean GM_MG        = new EnumBean("8",   "GM_MG");
    public static final EnumBean GM_PT        = new EnumBean("9",   "GM_PT");
    public static final EnumBean GM_GROUP_AG  = new EnumBean("10",  "GM_GROUP_AG");
    public static final EnumBean GM_GROUP_PNG = new EnumBean("11",  "GM_GROUP_PNG");
    public static final EnumBean GM_GROUP_GG  = new EnumBean("12",  "GM_GROUP_GG");
}