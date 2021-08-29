package com.chuang.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.chuang.entity.User;
import com.chuang.mapper.UserMapper;
import com.chuang.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @program: Shop-Server
 * @description: 这个类相当于继承了 ServiceImpl  IUserService 并且把UserMapper(继承BaseMapper)的对象当泛型
 * @author: chuang
 * @create: 2021-06-07 19:26
 */
@Service  //注入组件
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {


}
