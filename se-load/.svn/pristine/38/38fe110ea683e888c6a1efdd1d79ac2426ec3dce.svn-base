package com.xjw.utility;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@SuppressWarnings("all")
public class BeanToMapUtil {
  private static final Logger logger = LoggerFactory.getLogger(BeanToMapUtil.class.getName());
  public static Object convertMap(Class type, Map map)
          throws IntrospectionException, IllegalAccessException,
          InstantiationException, InvocationTargetException {
      BeanInfo beanInfo = Introspector.getBeanInfo(type);
      Object obj = type.newInstance();

      PropertyDescriptor[] propertyDescriptors =  beanInfo.getPropertyDescriptors();
      for (int i = 0; i< propertyDescriptors.length; i++) {
          PropertyDescriptor descriptor = propertyDescriptors[i];
          String propertyName = descriptor.getName();

          if (map.containsKey(propertyName)) {
              Object value = map.get(propertyName);
              Object[] args = new Object[1];
              args[0] = value;
              descriptor.getWriteMethod().invoke(obj, args);
          }
      }
      return obj;
  }

  /**
   * 将一个 JavaBean 对象转化为一个  Map
   * @throws InvocationTargetException 
   * @throws IllegalAccessException 
   * @throws IllegalArgumentException 
   */
  public static Map convertBean(Object bean){
      Class type = bean.getClass();
      Map returnMap = new HashMap();
      BeanInfo beanInfo;
      try {
        beanInfo = Introspector.getBeanInfo(type);
        PropertyDescriptor[] propertyDescriptors =  beanInfo.getPropertyDescriptors();
        for (int i = 0; i< propertyDescriptors.length; i++) {
            PropertyDescriptor descriptor = propertyDescriptors[i];
            String propertyName = descriptor.getName();
            if (!propertyName.equals("class")) {
                Method readMethod = descriptor.getReadMethod();
                Object result = readMethod.invoke(bean, new Object[0]);
                if (result != null) {
                    returnMap.put(propertyName, result);
                } else {
                    returnMap.put(propertyName, "");
                }
            }
        }
      } catch (Exception e) {
        logger.error(e.getMessage(), e);
      }
      return returnMap;
  }
}
