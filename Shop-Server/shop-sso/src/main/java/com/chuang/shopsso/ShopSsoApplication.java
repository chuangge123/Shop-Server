package com.chuang.shopsso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @program: Shop-Server
 * @description: 启动类
 * @author: chuang
 * @create: 2021-08-09 16:10
 */
@SpringBootApplication(scanBasePackages = "com.chuang",exclude = DataSourceAutoConfiguration.class)
@EnableEurekaClient
@EnableFeignClients("com.chuang.feign.api")
public class ShopSsoApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopSsoApplication.class,args);
    }
}
