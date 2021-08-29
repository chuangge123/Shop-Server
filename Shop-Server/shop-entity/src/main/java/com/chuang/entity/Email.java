package com.chuang.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: Shop-Server
 * @description: Email-entitiy
 * @author: chuang
 * @create: 2021-08-02 07:57
 */
@Data
public class Email implements Serializable {
    private String title;

    private String content;

    private String toUser; // 收件人

    private String ccUser; // 抄送人
}
