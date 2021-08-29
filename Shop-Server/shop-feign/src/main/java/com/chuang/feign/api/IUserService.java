package com.chuang.feign.api;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chuang.entity.ResultEntity;
import com.chuang.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Map;

/**
 * @program: Shop-Server
 * @description: feign
 * @author: chuang
 * @create: 2021-06-08 14:18
 */
@FeignClient("shop-user")
public interface IUserService {
    @RequestMapping("/user/addUser")
    public ResultEntity addUser(@RequestBody User user);
    @RequestMapping("/user/getUserPage")
    public Page<User> getUserPage(@RequestBody Map<String, Object> map);
    @RequestMapping("/user/getUserById/{id}")
    public User getUserById (@PathVariable Integer id);
    @RequestMapping("/user/updateUser")
    public ResultEntity updateUser(@RequestBody User user);
    @RequestMapping("/user/userBatchDel")
    public ResultEntity userBatchDel(@RequestParam("userIdList") ArrayList<Integer> userIdList);

}
