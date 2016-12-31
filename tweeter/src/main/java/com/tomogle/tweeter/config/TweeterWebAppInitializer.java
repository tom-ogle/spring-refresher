package com.tomogle.tweeter.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Configuration class used instead of a web.xml file
 */
public class TweeterWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
  @Override protected Class<?>[] getRootConfigClasses() {
    return new Class<?>[] { TweeterRootConfig.class };
  }

  @Override protected Class<?>[] getServletConfigClasses() {
    return new Class<?>[] { TweeterWebConfig.class };
  }

  @Override protected String[] getServletMappings() {
    return new String[] { "/" };
  }
}
