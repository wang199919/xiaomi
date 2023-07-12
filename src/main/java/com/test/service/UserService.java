package com.test.service;

import com.test.exception.ExceptionEnum;
import com.test.exception.XmlException;
import com.test.mapper.UserMapper;
import com.test.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: roy
 * @date: 2023/7/12 21:13
 * @description:
 */
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public  User login(User user){
        User one=userMapper.selectOne(user);
        if(one==null){
            throw  new XmlException(ExceptionEnum.GET_USER_NOT_FOUND);
        }
        return  one;
    }
}
