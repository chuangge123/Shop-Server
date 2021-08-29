package com.chuang.feign.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chuang.entity.ResultEntity;
import com.chuang.entity.User;
import com.chuang.feign.api.IUserService;

import java.util.ArrayList;
import java.util.Map;

/**
 * @program: Shop-Server
 * @description: feign 的降级方法
 * @author: chuang
 * @create: 2021-06-08 14:27
 */
public class UserServiceImpl implements IUserService {
    @Override
    public ResultEntity addUser(User user) {
        return null;
    }

    @Override
    public Page<User> getUserPage(Map<String, Object> map) {
        return null;
    }


    @Override
    public User getUserById(Integer id) {
        return null;
    }

    @Override
    public ResultEntity updateUser(User user) {
        return null;
    }

    @Override
    public ResultEntity userBatchDel(ArrayList<Integer> userIdList) {
        return null;
    }
}
