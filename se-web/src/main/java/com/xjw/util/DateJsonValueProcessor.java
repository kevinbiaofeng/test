//package com.xjw.util;
//
//import java.util.Calendar;
//import java.util.Date;
//
//import org.apache.commons.lang3.time.DateFormatUtils;
//
//public class DateJsonValueProcessor implements JsonValueProcessor {
//	
//	public Object processArrayValue(Object value, JsonConfig jsonConfig) {
//		return this.process(value);
//	}
//
//	public Object processObjectValue(String key, Object value, JsonConfig jsonConfig) {
//		return this.process(value);
//	}
//	
//	private Object process(Object value) {
//		try {
//			if (value instanceof Date || value instanceof Calendar){
//				return DateFormatUtils.format((Date)value, "yyyy-MM-dd HH:mm:ss");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return value == null ? "" : value.toString();
//	}
//}
