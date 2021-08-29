package com.chuang.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: Shop-Server
 * @description: 异常实体类
 * @author: chuang
 * @create: 2021-06-10 11:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopException extends RuntimeException {
    private String code;
    private String msg;

}
