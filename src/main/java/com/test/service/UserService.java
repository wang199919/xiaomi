package com.test.service;

import com.test.exception.ExceptionEnum;
import com.test.exception.XmlException;
import com.test.mapper.UserMapper;
import com.test.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * @author: roy
 * @date: 2023/7/12 21:13
 * @description:
 */
@Service
public interface UserService {
    public User getByUsername(String username);
}
