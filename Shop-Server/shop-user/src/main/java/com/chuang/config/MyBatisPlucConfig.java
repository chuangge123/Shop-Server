package com.chuang.config;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: Shop-Server
 * @description: 配置分页拦截器
 * @author: chuang
 * @create: 2021-06-08 08:56
 */
@Configuration
public class MyBatisPlucConfig {
    @Bean
    public PaginationInterceptor paginationInterceptor (){
        return new PaginationInterceptor();
    }

}
