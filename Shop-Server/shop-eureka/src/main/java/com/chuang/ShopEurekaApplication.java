package com.chuang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @program: Shop-Server
 * @description: shop-eureka
 * @author: chuang
 * @create: 2021-06-07 15:51
 */
@SpringBootApplication
@EnableEurekaServer
public class ShopEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopEurekaApplication.class,args);
    }
}
