package com.xjw.common.util;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import com.xjw.utility.PropertiesUtils;

public class SystemConstant {
  private static Logger logger= LoggerFactory.getLogger(SystemConstant.class.getName());


  private static Properties properties;
  static {
    try {
      properties = PropertiesUtils.loadProperties("classpath:/conf/config.properties");
    } catch (IOException e) {
      logger.error("加载、读取系统域名URL异常。", e);
    }
  }

  public static Properties getProperties() {
    return properties;
  }
}
