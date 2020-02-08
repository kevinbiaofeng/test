package com.xjw.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.xjw.common.util.Constant;
import com.xjw.entity.po.sys.Dept;
import com.xjw.entity.po.sys.User;

public class SessionManager {
  public static User getUserSession(HttpServletRequest request) {
    return (User)request.getSession().getAttribute(Constant.USER_SESSION);
  }
  
  public static Dept getDeptSession(HttpServletRequest request) {
    return (Dept)request.getSession().getAttribute(Constant.DEPT_SESSION);
  }
  
  @SuppressWarnings("unchecked")
  public static Map<String, Object> getAuthSession(HttpServletRequest request) {
    return (Map<String, Object>)request.getSession().getAttribute(Constant.AUTH_MAP_SESSION);
  }
}
