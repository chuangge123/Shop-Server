package com.chuang.config;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: Shop-Server
 * @description: 映射
 * @author: chuang
 * @create: 2021-06-13 19:36
 */
public class WebMVCConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/toAddUserPage").setViewName("user/addUser");
        registry.addViewController("/toAddGoodsPage").setViewName("goods/addGoods");
    }
}
