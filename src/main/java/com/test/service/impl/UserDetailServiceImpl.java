package com.test.service.impl;

import com.test.pojo.AccountUser;
import com.test.pojo.User;
import com.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: roy
 * @date: 2023/7/14 12:31
 * @description:
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {
     @Autowired
    UserService userService;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user=userService.getByUsername(s);
            if(user ==null){
                throw  new UsernameNotFoundException("用户名或密码错误");
            }
            return new AccountUser(user.getUserId(),user.getPassword(),user.getUsername(),getUserAuthority(user.getUserId()));

        }
        public List<GrantedAuthority> getUserAuthority(Long userId) {
            // 实际怎么写以数据表结构为准，这里只是写个例子
            // 角色(比如ROLE_admin)，菜单操作权限(比如sys:user:list)
            return AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_admin");
        }
    }

