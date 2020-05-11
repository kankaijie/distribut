package com.org.tx.zuul.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZuulConfig {

    @Bean
    public MyZuulFilter myZuulFilter(){
        return new MyZuulFilter();
    };
}
