package com.test.mapper;


import com.test.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: roy
 * @date: 2023/7/12 21:12
 * @description:
 */
@Repository
public interface  UserMapper extends JpaRepository<User,Long> {
    User findAllByUsername(String username);
}


