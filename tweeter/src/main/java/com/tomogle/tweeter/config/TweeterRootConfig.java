package com.tomogle.tweeter.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.springframework.context.annotation.FilterType.*;

@Configuration
@ComponentScan(
    basePackages = { "com.tomogle.tweeter" },
    excludeFilters = {
        @ComponentScan.Filter(type = ANNOTATION, value = EnableWebMvc.class)
    }
)
public class TweeterRootConfig {
}
