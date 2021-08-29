package com.chuang.shopzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @program: Shop-Server
 * @description: shopzuul
 * @author: chuang
 * @create: 2021-06-07 16:53
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ShopZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopZuulApplication.class, args);
    }
}
