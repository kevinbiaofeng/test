package com.xjw.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.xjw.common.util.Constant;
import com.xjw.utility.RequestResponseContextUtil;

public class SystemInterceptor extends HandlerInterceptorAdapter {
	private static Logger logger = LoggerFactory.getLogger(SystemInterceptor.class.getName());
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		RequestResponseContextUtil.setResponse(response);
		logger.info("==============拦截器地址================");
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url = requestUri.substring(contextPath.length());
		logger.debug("contextPath:" + contextPath);
		logger.debug("url:" + url);
		Object obj = request.getSession().getAttribute(Constant.USER_SESSION);
		if (null == obj) {
			// response.setCharacterEncoding("utf-8");
			// response.setContentType("text/html; charset=utf-8");
			// PrintWriter out = response.getWriter();
			// StringBuilder builder = new StringBuilder();
			// builder.append("<script type=\"text/javascript\" charset=\"UTF-8\">");
			// builder.append("alert(\"请您先登录\");");
			// builder.append("window.top.location.href=\"");
			// builder.append(ContextUrlManager.getBasePath());
			// builder.append("\";</script>");
			// out.print(builder.toString());
			// out.close();
			response.sendRedirect(request.getContextPath() + "/user/index");
			return true;
		} else
			return true;

	}
}
