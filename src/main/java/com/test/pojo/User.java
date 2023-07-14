package com.test.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * @author: roy
 * @date: 2023/7/12 20:57
 * @description:
 */

@Data
@Entity
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private  Long  userId;
    private  String username;
    private String password;
}
