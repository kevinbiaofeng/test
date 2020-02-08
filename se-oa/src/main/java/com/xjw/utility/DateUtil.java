package com.xjw.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang3.time.DateFormatUtils;

public class DateUtil {

	/** 时间间隔类别  */
	public enum IntevalType{
		/**秒 */
		SECOND(1000),
		/** 分 */
		MINUTE(1000 * 60),
		/** 时 */
		HOUR(1000 * 60 * 60),
		/** 天 */
		DAY(1000 * 60 * 60 * 24);
		
		private long value;
		
		private IntevalType(long value){
			this.value = value;
		}
	}
	
	/**
	 * 计算日期的间隔时长
	 * @param cal1			日期1
	 * @param cal2			日期2
	 * @param intevalType	计算单位
	 * @return	间隔时长
	 */
	public static long getInterval(Calendar cal1, Calendar cal2, IntevalType intevalType){
		 long ms1 = cal1.getTimeInMillis();
		 long ms2 = cal2.getTimeInMillis();
		 return Math.abs(ms2-ms1)/intevalType.value;	
	}
	
	/**
	 * 计算日期的间隔时长
	 * @param date1			日期1
	 * @param date2			日期2
	 * @param intevalType	计算单位
	 * @return	间隔时长
	 */
	public static long getInterval(Date date1, Date date2, IntevalType intevalType){
		long ms1 = date1.getTime();
		long ms2 = date2.getTime();
		return Math.abs(ms2-ms1)/intevalType.value;	
	}
	
	/**
	 * 计算日期与系统时间的间隔时长
	 * @param cal1			日期1
	 * @param cal2			日期2
	 * @param intevalType	计算单位
	 * @return	间隔时长
	 */
	public static long getInterval(Calendar cal, IntevalType intevalType){
		Calendar nowTime = Calendar.getInstance();
		long ms1 = nowTime.getTimeInMillis();
		long ms2 = cal.getTimeInMillis();
		return Math.abs(ms2-ms1)/intevalType.value;
	}
	
	/**
	 * 计算日期与系统时间的间隔时长
	 * @param cal1			日期1
	 * @param cal2			日期2
	 * @param intevalType	计算单位
	 * @return	间隔时长
	 */
	public static long getInterval(Date date, IntevalType intevalType){
		Date nowTime = Calendar.getInstance().getTime();
		long ms1 = nowTime.getTime();
		long ms2 = date.getTime();
		return Math.abs(ms2-ms1)/intevalType.value;
	}
	
	/**
	 * 日期加一天
	 * @param date
	 * @return
	 */
	public static String addDay (String dateStr, String format){
		Date date;
		try {
			date = (new SimpleDateFormat(format)).parse(dateStr);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.DATE, 1);
			return new SimpleDateFormat(format).format(cal.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 日期加一天
	 * @param date
	 * @return
	 */
	public static String addDays (String dateStr, String format, int days){
		Date date;
		try {
			date = (new SimpleDateFormat(format)).parse(dateStr);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.DATE, days);
			return new SimpleDateFormat(format).format(cal.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 日期减一天
	 * @param datestr
	 * @param format
	 * @return String
	 */
	public static String subDays(Date date, String format){
		try {
			Calendar caldate = Calendar.getInstance();
			caldate.setTime(date);
			caldate.set(Calendar.DATE, caldate.get(Calendar.DATE) - 21);
			return new SimpleDateFormat(format).format(caldate.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

	/**
	 * 格式化输出日期
	 * 
	 * @param date
	 *            日期
	 * @param format
	 *            格式
	 * @return 返回字符型日期
	 */
	public static String format(Date date, String format) {
		String result = "";
		try {
			if (date != null) {
				java.text.DateFormat df = new java.text.SimpleDateFormat(format);
				result = df.format(date);
			}
		} catch (Exception e) {
		}
		return result;
	}

	public static Calendar formatCalendar(String dateStr, String format) throws ParseException{
		Date date;
		date = (new SimpleDateFormat(format)).parse(dateStr);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}
	
	public static Date formatStr(String dateStr, String format) {
		Date date = null;
		try {
			if (dateStr != null) {
				java.text.DateFormat df = new java.text.SimpleDateFormat(format);
				date = df.parse(dateStr);
			}
		} catch (Exception e) {
			return null;
		}
		return date;
	}
	
	/** 三个小时之前的时间  */
	public static String getHourofDay(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.roll(Calendar.HOUR_OF_DAY, -5);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(calendar.getTime());
	}
	
	/** 获取某时刻过去的24小时 */
	public static Date getOneDayBefore(Date dateEnd){
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(dateEnd);
	    calendar.add(Calendar.HOUR, -24);//当前系统时间的  前24小时
	    return calendar.getTime();
	}
	
	/**获取前一个月的第一天  */
	public static String getBeforeMonthFirstDay(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
		Calendar cal_1 = Calendar.getInstance();//获取当前日期 
		cal_1.add(Calendar.MONTH, -1);
		cal_1.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天 
		return format.format(cal_1.getTime());
	}
	
	/** 获取前一个月的最后一天  */
	public static String getBeforeMonthLastDay(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cale = Calendar.getInstance();   
		cale.set(Calendar.DAY_OF_MONTH, 0);//设置为1号,当前日期既为本月第一天 
		return format.format(cale.getTime());
	}
	
	public static void main(String[] args) {
		Calendar cal = new GregorianCalendar(2016, 8, 1);
		System.out.println(DateFormatUtils.format(cal, "yyyy-MM-dd HH:mm:ss"));
		System.out.println(DateUtil.getInterval(cal.getTime(), IntevalType.DAY));
		getOneDayBefore(new Date());
		System.out.println(getBeforeMonthFirstDay());
		System.out.println(getBeforeMonthLastDay());
	}
}
