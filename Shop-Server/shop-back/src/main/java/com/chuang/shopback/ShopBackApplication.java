package com.chuang.shopback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @program: Shop-Server
 * @description: 启动
 * @author: chuang
 * @create: 2021-06-08 10:16
 */
@SpringBootApplication(scanBasePackages = "com.chuang",exclude = DataSourceAutoConfiguration.class)
@EnableEurekaClient
@EnableFeignClients("com.chuang.feign.api")
public class ShopBackApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopBackApplication.class,args);
    }
}
