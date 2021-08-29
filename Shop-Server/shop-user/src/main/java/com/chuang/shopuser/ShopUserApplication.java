package com.chuang.shopuser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @program: Shop-Server
 * @description: shopuser
 * @author: chuang
 * @create: 2021-06-07 17:21
 */
@EnableEurekaClient
@SpringBootApplication(scanBasePackages = "com.chuang")
@MapperScan(basePackages = "com.chuang.mapper")
public class ShopUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopUserApplication.class,args);
    }
}
