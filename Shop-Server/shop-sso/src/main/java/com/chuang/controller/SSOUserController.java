package com.chuang.controller;

import com.chuang.constants.ShopConstants;
import com.chuang.entity.Email;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @program: Shop-Server
 * @description: 用户登录接口
 * @author: chuang
 * @create: 2021-08-09 16:16
 */
@RestController
@RequestMapping("/ssoUserController")
@Slf4j
public class SSOUserController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;
    @PostMapping("/sendEmail")
    public String sendEmail(String emailStr){
        //随机生成随机数
        String code = RandomStringUtils.random(6, false, true);

        // 把验证码保存到redis中 ,把邮箱和验证码绑定
        stringRedisTemplate.opsForValue().set(ShopConstants.SSO_REGISTER_KEY + emailStr,code,120, TimeUnit.SECONDS);
        //创建邮箱对象
        Email email = new Email();
        email.setTitle("新用户注册");
        email.setContent("尊敬的用户，您的验证码为:"+ code);
        email.setToUser(emailStr);

        //这里发送email,异步调邮件服务
        rabbitTemplate.convertAndSend(ShopConstants.EMAIL_EXCHANGE,ShopConstants.EMAIL_ROUTING_KEY,email);

        //返回
        return "ok";


    }
}
