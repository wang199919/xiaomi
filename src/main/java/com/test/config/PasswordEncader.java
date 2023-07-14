package com.test.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author: roy
 * @date: 2023/7/14 13:07
 * @description:
 */
public class PasswordEncader extends BCryptPasswordEncoder {
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return super.matches(rawPassword, encodedPassword);
    }
}
