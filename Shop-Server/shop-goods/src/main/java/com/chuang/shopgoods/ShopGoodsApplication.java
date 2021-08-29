package com.chuang.shopgoods;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @program: Shop-Server
 * @description: shop-goods
 * @author: chuang
 * @create: 2021-06-11 09:53
 */
@SpringBootApplication(scanBasePackages = "com.chuang")
@EnableEurekaClient
@MapperScan(basePackages = "com.chuang.mapper")//.mapper
public class ShopGoodsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopGoodsApplication.class,args);
    }
}
