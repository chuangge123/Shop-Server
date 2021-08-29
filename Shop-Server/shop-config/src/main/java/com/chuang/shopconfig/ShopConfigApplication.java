package com.chuang.shopconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @program: Shop-Server
 * @description: config
 * @author: chuang
 * @create: 2021-06-07 15:05
 */
@SpringBootApplication
@EnableConfigServer
public class ShopConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopConfigApplication.class,args);
    }
}
