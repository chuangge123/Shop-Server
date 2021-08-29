package com.chuang.shopemail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @program: Shop-Server
 * @description: 启动
 * @author: chuang
 * @create: 2021-08-02 08:05
 */
@SpringBootApplication(scanBasePackages = "com.chuang",exclude = DataSourceAutoConfiguration.class)
public class ShopEmailApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopEmailApplication.class,args);
    }
}
