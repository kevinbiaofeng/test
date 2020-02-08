package com.xjw.interceptor;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.xjw.common.util.Constant;
import com.xjw.entity.po.user.User;
import com.xjw.service.user.UserService;
import com.xjw.util.CookieManager;
import com.xjw.util.GetAddressByIp;
import com.xjw.util.SessionManager;
import com.xjw.utility.IpUtil;
import com.xjw.utility.RequestResponseContextUtil;
import com.xjw.utility.SpringContextHolder;

public class AutoLoginInterceptor extends HandlerInterceptorAdapter {
	private static Logger logger = LoggerFactory.getLogger(AutoLoginInterceptor.class.getName());
//	@Resource
//	private UserAccountIntegralService userAccountIntegralService;
//	@Resource
//	private UserService userService;
	
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	  RequestResponseContextUtil.setResponse(response);
	    String requestUri = request.getRequestURI();
	  UserService userService = SpringContextHolder.getBean(UserService.class);
	  logger.debug("requestUri:" + requestUri);    
	  Map<String, Cookie> map = CookieManager.readCookieMap(request);
	  if(map != null){
		  Cookie nu = map.get("un");	// 用户名称
		  Cookie ui = map.get("ui");	//账户余额
		  if(nu != null && ui != null) {
			  Map<String, Object> modifyParams = new HashMap<String, Object>();
			  String name = CookieManager.cookieEncryptDecode(Constant.CookieDateEncryptManage.NAME, nu.getValue());
			  User sessUser = SessionManager.getUserSession(request);
			  
			  if(sessUser != null){
				  if(sessUser.getSessionSidTime() == null || sessUser.getSessionSidTime().before(new Date())){
					  //用户登录时间过期，需要重新登录
					  CookieManager.delCookie(request, response, "un");
					  CookieManager.delCookie(request, response, "ui");
					  CookieManager.delCookie(request, response, "s");
					  SessionManager.removeUserSession(request);
				  }
			  }else{
				  Cookie s = map.get("s");
				  if(s != null){
					  String sessionSid = s.getValue();
					  sessUser = userService.getUserByNameAndSessionSid(name, sessionSid);
					  if(sessUser != null){
						  //登录的用户保存用户信息到session、cookie
						  userService.setLoginUserParam(sessUser, request, response, sessionSid);
						  
						  //记录登录日志
						  String ip = IpUtil.getIpAddr(request);
						  modifyParams.put("id", sessUser.getId());
						  modifyParams.put("loginTime", new Date());
						  modifyParams.put("loginIp", ip);
						  modifyParams.put("loginIpCityInfo", GetAddressByIp.GetAddressByIp01(ip));
						  userService.update(modifyParams);
						  userService.excuUpdateUserLoginIpAddress(sessUser.getId(), ip);
						  
					  }else{
						  CookieManager.delCookie(request, response, "un");
						  CookieManager.delCookie(request, response, "ui");
						  CookieManager.delCookie(request, response, "s");
					  }
				  }
			  }
		  }
	  }
	  
      return true;
  }
}
