package com.chuang.service;

import com.chuang.entity.Email;

import javax.mail.MessagingException;

/**
 * @program: Shop-Server
 * @description: 业务类
 * @author: chuang
 * @create: 2021-08-09 11:25
 */
public interface IEmailService {
    public void sendEmail(Email email) throws MessagingException;
}
