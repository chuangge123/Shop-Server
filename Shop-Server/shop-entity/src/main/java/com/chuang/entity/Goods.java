package com.chuang.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @program: Shop-Server
 * @description: 商品实体
 * @author: chuang
 * @create: 2021-06-11 09:05
 */
@Data
@TableName("t_goods")
public class Goods {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String gname;
    private Integer gtype;
    private BigDecimal gprice;
    private String gdesc;

    @TableField(exist = false)
    private String tempPng;
    @TableField(exist = false)
    private List<GoodsPic> goodsPicList;
}
