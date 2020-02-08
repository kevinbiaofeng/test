package com.xjw.util;

import java.util.HashMap;
import java.util.Map;

import com.xjw.entity.po.sys.User;
import com.xjw.utility.BizException;

public class CurrentUserHolder {

  public static final String CURRENT_USER = "currentUser";
  private static final ThreadLocal<Map<String, Object>> threadSession = new ThreadLocal<Map<String, Object>>();

  private static Map<String, Object> getThreadLocalMap() {
    Map<String, Object> map = threadSession.get();
    if (map == null) {
      map = new HashMap<String, Object>();
    }
    return map;
  }

  private static void set(String key, Object value) {
    Map<String, Object> map = getThreadLocalMap();
    map.put(key, value);
    threadSession.set(map);
  }

  public static Long getCurrentUserId() throws BizException {
    Long curUserId = getUserId();
    if (curUserId == null) {
      String msg = "当前用户已退出登录,无法获取到当前登录用户信息。";
      throw new BizException(msg);
    }
    return curUserId;
  }

  private static Long getUserId() {
    return ((User) getThreadLocalMap().get(CURRENT_USER)).getId();
  }
  
  public static Integer getCurrentUserType() {
    return ((User) getThreadLocalMap().get(CURRENT_USER)).getType();
  }
  
  public static Long getCurrentUserParentId() {
    return ((User) getThreadLocalMap().get(CURRENT_USER)).getParentId();
  }
  
  public static User getCurrentUser() {
    return (User) getThreadLocalMap().get(CURRENT_USER);
  }

  public static void set(User user) {
    set(CURRENT_USER, user);
  }

  public static void initSystemUserInfo(User user) {
    Map<String, Object> map = getThreadLocalMap();
    map.put(CURRENT_USER, user);
    threadSession.set(map);
  }
}