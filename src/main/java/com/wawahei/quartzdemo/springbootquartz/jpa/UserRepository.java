package com.wawahei.quartzdemo.springbootquartz.jpa;

import com.wawahei.quartzdemo.springbootquartz.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @description:
 * @author: yanghailang
 * @create: 2020-12-22 17:26
 **/
public interface UserRepository extends JpaRepository<User,Integer>{
}