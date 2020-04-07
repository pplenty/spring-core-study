package com.jason.springcorestudy.config;

import com.jason.springcorestudy.interceptor.HomeInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author playjun
 * @since 2019 09 20
 */
@Configuration
public class MvcConfiguration extends WebMvcConfigurationSupport {
    public MvcConfiguration() {
        System.out.println("@@@MvcConfiguration@@@@@@@@@@@@");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        System.out.println("@@@addadaddaad@@@@@@@@@@@@");
        registry.addInterceptor(new HomeInterceptor())
                .addPathPatterns("/*");
    }
}

