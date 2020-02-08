package com.xjw.utility;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.DefaultPropertiesPersister;
import org.springframework.util.PropertiesPersister;

public class PropertiesUtils {
  private static Logger logger= LoggerFactory.getLogger(PropertiesUtils.class.getName());
  private static final String DEFAULT_ENCODING = "UTF-8";

  private static PropertiesPersister propertiesPersister = new DefaultPropertiesPersister();
  private static ResourceLoader resourceLoader = new DefaultResourceLoader();

  public static Properties loadProperties(String... resourcesPaths) throws IOException {
    Properties props = new Properties();

    for (String location : resourcesPaths) {
      logger.debug("Loading properties file from:" + location);

      InputStream is = null;
      try {
        Resource resource = resourceLoader.getResource(location);
        is = resource.getInputStream();
        propertiesPersister.load(props, new InputStreamReader(is, DEFAULT_ENCODING));
      } catch (IOException ex) {
        logger.error("Could not load properties from classpath:" + location + ": " + ex.getMessage());
      } finally {
        if (is != null) {
          is.close();
        }
      }
    }
    return props;
  }
}