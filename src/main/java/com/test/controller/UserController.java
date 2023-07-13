package com.test.controller;

import com.test.pojo.User;
import com.test.service.UserService;
import com.test.util.MD5Util;
import com.test.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * @author: roy
 * @date: 2023/7/12 22:05
 * @description:ee
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;
    @PostMapping("/login")

    public ResultMessage login(@RequestBody User user){
        user=service.login(user);
        String encode= MD5Util.MD5Encode(user.getUsername()+user.getPassword(),"UTF-8");
        encode +="|"+user.getUserId()+"|" +user.getUsername()+"|";
        user.setPassword(null);
        System.out.println("登陆成功"+user);
       return ResultMessage.success("001","登陆成功",user);
    }

}
