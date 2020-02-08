package com.xjw.interceptor;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.xjw.common.util.Constant;
import com.xjw.entity.po.sys.User;
import com.xjw.utility.ContextUrlManager;
import com.xjw.utility.CurrentUserHolder;
import com.xjw.utility.RequestResponseContextUtil;

@Repository
public class SystemInterceptor extends HandlerInterceptorAdapter {

  // @Resource(name = "systemLoggerService")
  // private SystemLoggerService systemLoggerService;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    RequestResponseContextUtil.setResponse(response);
    String requestUri = request.getRequestURI();
    for (String url : excludedUrls) {
      if (requestUri.endsWith(url)) {
        return true;
      }
    }
    Object obj = request.getSession().getAttribute(Constant.USER_SESSION);
    if (null == obj) {
      // 未登录
      response.setCharacterEncoding("utf-8");        
      response.setContentType("text/html; charset=utf-8");    
      PrintWriter out = response.getWriter();
      StringBuilder builder = new StringBuilder();
      builder.append("<script type=\"text/javascript\" charset=\"UTF-8\">");
      builder.append("alert(\"页面过期，请重新登录\");");
      builder.append("window.top.location.href=\"");
      builder.append(ContextUrlManager.getBasePath());
      builder.append("\";</script>");
      out.print(builder.toString());
      out.close();
      return false;
    } else {
      CurrentUserHolder.initSystemUserInfo(((User)obj).getId());
      return true;
    }

    // Map paramsMap = request.getParameterMap();

  }

  private List<String> excludedUrls;

  public void setExcludedUrls(List<String> excludedUrls) {
    this.excludedUrls = excludedUrls;
  }
}
