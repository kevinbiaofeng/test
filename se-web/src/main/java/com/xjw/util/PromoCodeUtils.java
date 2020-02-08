package com.xjw.util;

/**
 * 用户推广码生成工具类 
 */
public class PromoCodeUtils {
	
	/** 此处常量一经修改，用户的推广码也会随之变更 */
	public final static String CHARS = "q2sm6dfk3e"; 
	
	public static String encode(long value){
		char[] cs = String.valueOf(value).toCharArray();
		
		StringBuilder sb = new StringBuilder();
		for(char c : cs){
			int index = Integer.parseInt(String.valueOf(c));
			sb.append(CHARS.charAt(index));
		}
		
		return sb.toString();
	}
	
	public static long decode(String value){
		char[] cs = value.toCharArray();
		
		StringBuilder sb = new StringBuilder();
		for(char c : cs){
			sb.append(CHARS.indexOf(c));
		}
		
		return Long.parseLong(sb.toString());
	}
	
	public static void main(String[] args) {
		Long value = 17890L;
		
		String en = encode(value);
		System.out.println(en);
		
		long de = decode(en);
		System.out.println(de);
		
	}
}

	