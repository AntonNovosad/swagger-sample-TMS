package com.example.demo.configuration;

import com.example.demo.interceptor.UserInSystemInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class AppConfiguration extends WebMvcConfigurerAdapter {
    @Autowired
    UserInSystemInterceptor userInSystemInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userInSystemInterceptor).addPathPatterns("/store/*", "/store/**", "/pet/*", "/pet/**");
    }
}
