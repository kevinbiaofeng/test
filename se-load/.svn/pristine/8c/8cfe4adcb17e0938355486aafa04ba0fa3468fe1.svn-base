package com.xjw.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorParameterUtil {
	/**
	 * 验证IP地址
	 * @return true 正确 false 错误IP
	 */
	public static boolean valIp(String ipAddr){
		Pattern pattern = Pattern.compile("\\b((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\b");
		Matcher matcher = pattern.matcher(ipAddr); //以验证127.400.600.2为例
		return matcher.matches();
	}
	
	/**
	 * 验证日期格式
	 * @param date
	 * @return
	 */
	public static boolean valDate(String date){
		Pattern pattern = Pattern.compile("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$");
		Matcher matcher = pattern.matcher(date);
		return matcher.matches();
	}
	
	/**
	 * 验证手机
	 * @param mobiles
	 * @return
	 */
	public static boolean isMobileNO(String mobile){     
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");     
        Matcher m = p.matcher(mobile);     
        return m.matches();     
    } 
   
	/**
	 * 验证邮箱
	 * @param email
	 * @return
	 */
    public static boolean isEmail(String email){     
    	String str="^([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)*@([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)+[\\.][A-Za-z]{2,3}([\\.][A-Za-z]{2})?$";
        Pattern p = Pattern.compile(str);     
        Matcher m = p.matcher(email);     
        return m.matches();     
    } 
	
	public static void main(String[] args) {
		ValidatorParameterUtil.valIp("192.168.1.1");
		ValidatorParameterUtil.valIp("2000-02-29 23:59:59");
	}
}
