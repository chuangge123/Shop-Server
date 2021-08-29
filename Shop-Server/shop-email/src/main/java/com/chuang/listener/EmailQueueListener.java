package com.chuang.listener;

import com.chuang.constants.ShopConstants;
import com.chuang.entity.Email;
import com.chuang.service.IEmailService;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.context.annotation.Configuration;

import javax.mail.MessagingException;
import java.io.IOException;

/**
 * @program: Shop-Server
 * @description: 监听器
 * @author: chuang
 * @create: 2021-08-09 11:23
 */
@Configuration
@Slf4j
public class EmailQueueListener {
    @Autowired
    private IEmailService emailService;
    @RabbitListener(queues = ShopConstants.EMAIL_QUEUE)
    public void sendEmail(Email email, Channel channel, Message message) throws MessagingException {
        log.debug("{}",email);
        //发送邮件
        emailService.sendEmail(email);
        //手动ack
        try {
            //消息唯一标识
            long deliveryTag = message.getMessageProperties().getDeliveryTag();
            channel.basicAck(deliveryTag,false);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
