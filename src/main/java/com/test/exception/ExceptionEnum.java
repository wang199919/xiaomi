package com.test.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author: roy
 * @date: 2023/7/12 21:24
 * @description:
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnum {
    GET_USER_NOT_FOUND(502,"用户名或密码错误"),
    GET_USER_REUSE(502,"用户名或密码错误"),
    SAVE_USER_ERROR(502,"注册用户错误");


private  int code;
private  String msg;
}
