package com.chuang.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chuang.entity.ResultEntity;
import com.chuang.entity.User;
import com.chuang.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @program: Shop-Server
 * @description: UserController
 * @author: chuang
 * @create: 2021-06-07 19:34
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userservice;

    @RequestMapping("/addUser")
    public ResultEntity addUser(@RequestBody User user){
        boolean insert = userservice.insert(user);
        return ResultEntity.ResponseClient(userservice.insert(user));
    }
    @RequestMapping("/getUserPage")
    public Page<User> getUserPage(@RequestBody Map<String, Object> map) {
//        log.debug("{}", map);
        System.out.println(map);

        // 0.从map取出需要的参数
        Object current = map.get("current");
        Object size = map.get("size");
        Object username = map.get("username");
        Object email = map.get("email");
        Object phone = map.get("phone");


        // 1.创建一个分页对象
        Page<User> page = new Page<>();
        if (!StringUtils.isEmpty(current)) {
            // current存在值
            page.setCurrent(Integer.parseInt(current.toString()));
        }

        if (!StringUtils.isEmpty(size)) {
            page.setSize(Integer.parseInt(size.toString()));
        }


        // 2.创建一个条件查询的对象
        EntityWrapper<User> entityWrapper = new EntityWrapper();
        if (!StringUtils.isEmpty(username)) {
            entityWrapper.like("username",username.toString());
        }
        if (!StringUtils.isEmpty(email)) {
            entityWrapper.like("email",email.toString());
        }
        if (!StringUtils.isEmpty(phone)) {
            entityWrapper.like("phone",phone.toString());
        }

        // 3.查询数据
        return userservice.selectPage(page, entityWrapper);
    }
    @RequestMapping("/getUserById/{id}")
    public User getUserById (@PathVariable Integer id){
        return userservice.selectById(id);
    }
    @RequestMapping("/updateUser")
    public ResultEntity updateUser(@RequestBody User user){
        return ResultEntity.ResponseClient(userservice.updateById(user));
    }
    @RequestMapping("/userBatchDel")
    public ResultEntity userBatchDel(@RequestParam("userIdList") ArrayList<Integer> userIdList){

//        List<Integer> integers = Arrays.asList(userIdList);

        boolean b = userservice.deleteBatchIds(userIdList);
        return ResultEntity.ResponseClient(b);

    }


}
