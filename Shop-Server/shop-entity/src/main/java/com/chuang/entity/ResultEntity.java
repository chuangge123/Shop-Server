package com.chuang.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.ResponseCache;

/**
 * @program: Shop-Server
 * @description: 返回相应实体
 * @author: chuang
 * @create: 2021-06-07 19:39
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultEntity<T> {
    private String status; //表示这次请求是成功或者是失败
    private String msg;  //表示失败的原因
    private T data;

    private static final String SUECCSS="sueccss";
    private static final String ERROR= "error";

    //成功返回 无数据
    public static <T> ResultEntity<T> success(){
        return new ResultEntity(SUECCSS,null,null);
    }
    //成功返回 有数据
    public static <T> ResultEntity<T> success(T t){
        return new ResultEntity(SUECCSS,null,t);
    }

    public static <T> ResultEntity<T> error(String msg){
        return new ResultEntity(ERROR,msg,null);
    }

    public static ResultEntity ResponseClient(boolean flag){
        if(flag){
            return ResultEntity.success();
        }else {
            return ResultEntity.error("添加用户失败");
        }

    }



}
