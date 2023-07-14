package com.test.pojo;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;

import java.util.Collection;

/**
 * @author: roy
 * @date: 2023/7/14 11:40
 * @description:
 */
public class AccountUser implements UserDetails {
    private  Long userId;
    private  String password;
    private  String username;

    private  static  final long serialVersionUID=540L;
    private  static  final Log logger= LogFactory.getLog(User.class);
    private  final Collection<? extends  GrantedAuthority> authorities;
    private  final  boolean accountNonExpired;
    private  final  boolean accountNonLocked;
    private  final  boolean credentialsNonExpired;
    private  final  boolean enabled;

    public AccountUser(Long userId, String password, String username,Collection<? extends  GrantedAuthority> authorities){
        this(userId ,password ,username,authorities,true,true,true,true);
    }
    public AccountUser(Long userId, String password, String username, Collection<? extends GrantedAuthority> authorities, boolean accountNonExpired, boolean accountNonLocked, boolean credentialsNonExpired, boolean enabled) {
        Assert.isTrue(username != null && !"".equals(username) && password != null, "Cannot pass null or empty values to constructor");
        this.userId = userId;
        this.password = password;
        this.username = username;
        this.authorities = authorities;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
