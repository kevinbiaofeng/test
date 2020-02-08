package com.xjw.utility;

import java.util.HashMap;
import java.util.Map;
public class CurrentUserHolder {

  public static final String CURRENT_USER_ID = "currentUserId";
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
//    if (curUserId == null) {
//      String msg = "当前用户已退出登录,无法获取到当前登录用户信息。";
//      throw new BizException(msg);
//    }
    return curUserId;
  }

  public static Long getUserId() {
    return (Long) getThreadLocalMap().get(CURRENT_USER_ID);
  }
  
  public static void set(Long id) {
    set(CURRENT_USER_ID, id);
  }

  public static void initSystemUserInfo(Long userId) {
    Map<String, Object> map = getThreadLocalMap();
    map.put(CURRENT_USER_ID, userId);
    threadSession.set(map);
  }
}