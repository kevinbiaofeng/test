package com.xjw.util;

import javax.servlet.http.HttpServletRequest;

import com.xjw.common.util.Constant;
import com.xjw.entity.po.user.User;

public class SessionManager {
  public static User getUserSession(HttpServletRequest request) {
    return (User)request.getSession().getAttribute(Constant.USER_SESSION);
  }
  
  public static void removeUserSession(HttpServletRequest request) {
	    request.getSession().removeAttribute(Constant.USER_SESSION);
  }
}
