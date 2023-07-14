package com.test.service.impl;

import com.test.exception.ExceptionEnum;
import com.test.exception.XmlException;
import com.test.mapper.UserMapper;
import com.test.pojo.AccountUser;
import com.test.pojo.User;
import com.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author: roy
 * @date: 2023/7/14 12:03
 * @description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User getByUsername(String username) {
        return userMapper.findAllByUsername(username);
    }
}

