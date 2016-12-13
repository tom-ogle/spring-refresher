package com.tomogle.springaccount;

import com.tomogle.springaccount.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    System.out.println(context.getBeanDefinitionCount());
    for(String name : context.getBeanDefinitionNames()) {
      System.out.println(name);
    }
  }
}
