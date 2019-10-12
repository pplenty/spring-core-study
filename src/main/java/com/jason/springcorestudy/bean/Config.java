package com.jason.springcorestudy.bean;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author : yusik
 * @date : 31/08/2019
 */
@Configuration
public class Config implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Bean
    public ObjectMapper objectMapper(RestTemplate restTemplate) {
        System.out.println(restTemplate);
        return new ObjectMapper();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
