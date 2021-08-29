package com.chuang.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.chuang.entity.ResultEntity;
import com.chuang.entity.User;
import com.chuang.feign.api.IUserService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @program: Shop-Server
 * @description:
 * @author: chuang
 * @create: 2021-06-08 14:09
 */
@Controller
@RequestMapping("userController")
public class UserController {
    @Autowired
    private IUserService iUserService;
    @RequestMapping("/getUserPage")
    public String getUserPage(HttpServletRequest request,Model model){
        //1.创建一个Map用来接收查询的参数
        HashMap<String, Object> map = new HashMap<>();

        //2.获取用户传递过来的参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        //将对应map关系转换为集合
        Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
        System.out.println(entries);
        //3.便利
        for (Map.Entry<String, String[]> entry : entries) {
            String key = entry.getKey();
            String value = entry.getValue()[0];
            //将取出的值和key 都存入到自定义Map
            map.put(key,value);
        }
        Page<User> page = iUserService.getUserPage(map);
        //将一些值放入model 进行与html页面交互。
        model.addAttribute("page",page);
        model.addAttribute("url","http://localhost/shop-back/userController/getUserPage");
        model.addAttribute("queryParamMap",map);
        return  "user/userList";

    }
    @RequestMapping("/addUser")
    @ResponseBody
    public ResultEntity addUser(User user){
        ResultEntity resultEntity = iUserService.addUser(user);
        return resultEntity;
    }
    @RequestMapping("/getUserById/{id}")
    public String getUserById(@PathVariable Integer id,Model model){
        User user = iUserService.getUserById(id);
        model.addAttribute("user",user);
        return "user/updateUser";
    }
    @RequestMapping("/updateUser")
    @ResponseBody
    public ResultEntity updateUser(@RequestBody User user){
        return iUserService.updateUser(user);
    }
//  测试一下全局异常类
//    @RequestMapping("/test")
//    @ResponseBody
//    public String test1(){
//        int i =10/0;
//        return "test1";
//    }

//    批量删除
    @RequestMapping("/userBatchDel")
    @ResponseBody     //通过@RequestParam进行"userIdList[]"与userIdList进行映射
    public ResultEntity userBatchDel(@RequestParam("userIdList[]") ArrayList<Integer> userIdList){


        return iUserService.userBatchDel(userIdList);
    }
}
