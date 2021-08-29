package com.chuang.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @program: Shop-Server
 * @description: 商品图片实体
 * @author: chuang
 * @create: 2021-06-11 09:20
 */
@Data
@TableName("t_goods_pic")
public class GoodsPic {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String png;
    private Integer gid;
}
