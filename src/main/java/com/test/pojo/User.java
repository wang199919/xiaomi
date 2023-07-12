package com.test.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author: roy
 * @date: 2023/7/12 20:57
 * @description:
 */

@Data
@Table(name= "user" )
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY ,generator = "JDBC")
    private  Integer  userId;
    private  String username;
    private String password;
}
