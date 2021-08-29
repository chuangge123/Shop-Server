package com.chuang.service.impl;

import com.chuang.entity.Email;
import com.chuang.service.IEmailService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @program: Shop-Server
 * @description: 实现类
 * @author: chuang
 * @create: 2021-08-09 11:26
 */
@Service
public class EmailServiceImpl implements IEmailService {
    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String fromuser;

    @Override
    public void sendEmail(Email email) throws MessagingException {
        //创建一个邮件发送类
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //创建一个邮件模板
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        //设置标题
        helper.setSubject(email.getTitle());
        //收件人
        helper.setTo(email.getToUser());
        //发件人
        helper.setFrom(fromuser);
        //抄送内容 true-代表是否识别html
        helper.setText(email.getContent(),true);
        //判断是否有抄送人
        if(StringUtils.isEmpty(email.getCcUser())){
            //如果没有抄送人，163发送邮件时把自己抄送上
            helper.setCc(new String[]{fromuser});
        }
        else{
            //有抄送人把自己和对方抄送上
            helper.setCc(new String[]{fromuser,email.getCcUser()});
        }
        //发送
        mailSender.send(mimeMessage);

    }
}
