package com.xjw.common.util;


public class Constant {
  /** \\/　左斜线 **/
  public static final String SLASH_MARK = "/";
  
  public static final String USER_SESSION = "user";
  public static final String DEPT_SESSION = "dept";
  
  public static final String AUTH_MAP_SESSION = "auth_map";  //用户权限
  
  public interface CommonManage {
    public static Integer YES = 1;
    public static Integer NO = 0;
  }
  
  public interface FinalResourceCodeManage {
    public static String BANK_TYPE = "USER_BANK_TYPE";
    public static String ACCOUNT_TYPE = "ACCOUNT_TYPE";
  }
  
  //数据库表名
  public interface FinalTableName {
	//资金调整
    public static String MEMBER_MONEY_CHANGE = "member_money_change";
    //存款
    public static String DEPOSIT = "user_deposit_order";
    //提款
    public static String WITHDRAWAL = "user_withdrawal_order";
    //反水
    public static String REBATE = "sys_rebate";
    //平台转账
    public static String PLATFORM_TRANSFER = "member_platform_transfer";
  }
  
  //功能CODE
  public interface FinalFunctionCode {
	//存款
    public static String DEPOSIT_CODE = "YWGL-ZJGL-CKDDTJ";
    //提款
    public static String WITHDRAWAL_CODE = "YWGL-ZJGL-TKDDTJ";
  }
  
  /**
   * 数据字段加密
   */
  public interface DateEncryptManage {
	public static String PWD_PWD = "88mdwKsent3";
    public static String SEX_PWD = "sk2388WjdK";
    public static String NAME_PWD = "Jwkej299k33";
    public static String PHONE_PWD = "88Fke29kdh";
    public static String EMAIL_PWD = "fjk39U8sas8";
    public static String QQ_PWD = "JS293kdhhw";
  }
}
