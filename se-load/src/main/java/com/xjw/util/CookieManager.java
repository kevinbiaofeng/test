package com.xjw.util;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import com.xjw.common.util.Constant;
import com.xjw.utility.EncryptUtil; 

public class CookieManager {
	private static Logger logger = LoggerFactory.getLogger(CookieManager.class.getName());
	
	/**
	   * 设置cookie
	   * @param response
	   * @param name  cookie名字
	   * @param value cookie值
	   * @param maxAge cookie生命周期  以秒为单位
	   */
	  public static void addCookie(HttpServletRequest request, HttpServletResponse response, String name, String value, int maxAge){
	      Cookie cookie = new Cookie(name, value);
	      cookie.setPath("/");
	      if(maxAge > 0) {
	    	  cookie.setMaxAge(maxAge);
	      }
	      response.addCookie(cookie);
	  }
	  
	  /**
	   * 删除cookie
	   * @param request
	   * @param response
	   * @param name
	   */
	  public static void delCookie(HttpServletRequest request, HttpServletResponse response, String name){
	      Cookie[] cookies = request.getCookies();
	      if (null == cookies) {
	    	  logger.info("没有找到用户Cookie ： " + name);
	      } else {
	          for(Cookie cookie : cookies){
	              if(cookie.getName().equals(name)){
	                  cookie.setPath("/");
	                  cookie.setMaxAge(0);
	                  response.addCookie(cookie);
	                  break;
	              }
	          }
	      }
	  }
	  
	  /**
	   * 根据cookie名获取cookie
	   * @param request
	   * @param cookieName
	   * @return
	   */
	  public static Cookie getCookie(HttpServletRequest request, String cookieName){
		  Cookie[] cookies = request.getCookies();
		  if (null != cookies) {
			  for(Cookie cookie : cookies){
				  if(cookieName.equals(cookie.getName())){
					  return cookie;
				  }
			  }
	      }
		  
		  return null;
	  }
	  
	  /**
	   * 将cookie封装到Map里面
	   * @param request
	   * @return
	   */
	  public static Map<String,Cookie> readCookieMap(HttpServletRequest request){  
	      Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
	      Cookie[] cookies = request.getCookies();
	      if(null != cookies){
	          for(Cookie cookie : cookies){
	              cookieMap.put(cookie.getName(), cookie);
	          }
	      }
	      return cookieMap;
	  }
	  
	  /** 
	     * 编码 
	     * @param cookieStr 
	     * @return 
	     */  
	    public static String encodeBase64(String cookieStr){  
	        try {  
	            cookieStr = new String(Base64.encodeBase64(cookieStr.getBytes("UTF-8")));  
	        } catch (UnsupportedEncodingException e) {  
	            e.printStackTrace();  
	        }  
	        return cookieStr;  
	    }  
	  
	    /** 
	     * 解码 
	     * @param cookieStr 
	     * @return 
	     */  
	    public static String decodeBase64(String cookieStr){  
	        try {  
	            cookieStr = new String(Base64.decodeBase64(cookieStr.getBytes()), "UTF-8");  
	        } catch (UnsupportedEncodingException e) {  
	            e.printStackTrace();  
	        }  
	        return cookieStr;  
	    }
	  
	  /**
	   * Cookie加密
	   * @return
	   */
	  public static String cookieEncryptEncode(String code, String str){
		  return EncryptUtil.encode(code, CookieManager.encodeBase64(str));
	  }
	  
	  /**
	   * Cookie解密
	   * @return
	   */
	  public static String cookieEncryptDecode(String code, String str){
		  String temp = EncryptUtil.decode(code, str);
		  return CookieManager.decodeBase64(temp);
	  }
	  
	  public static void main(String[] args) {
		  System.out.println(CookieManager.cookieEncryptEncode(Constant.CookieDateEncryptManage.NAME, "0"));
		  System.out.println(CookieManager.cookieEncryptDecode(Constant.CookieDateEncryptManage.NAME, "688883B8859FC4EA"));
	  }
}
