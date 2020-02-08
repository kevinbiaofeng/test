package com.xjw.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.xjw.utility.RequestResponseContextUtil;

public class SystemInterceptor extends HandlerInterceptorAdapter {
	private static Logger logger = LoggerFactory.getLogger(SystemInterceptor.class.getName());
	private static final String [] whiteDomain = {"http://www.lsj510.vip/", "http://www.lsj510.com/", "http://192.168.1.103:9090/"};
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		RequestResponseContextUtil.setResponse(response);
		logger.info("拦截路径：" + request.getHeader("Referer"));
		logger.info("系统路径：" + request.getRequestURI());
		String requestRemoteUri = request.getHeader("Referer");
		boolean y = false;
		for (String str : whiteDomain) {
			if(requestRemoteUri.indexOf(str) >= 0){
				y = true;
				break;
			}
		}
		return y;
	}
}
