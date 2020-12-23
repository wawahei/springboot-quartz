package com.wawahei.quartzdemo.springbootquartz.service.impl;

import com.wawahei.quartzdemo.springbootquartz.entity.User;
import com.wawahei.quartzdemo.springbootquartz.jpa.UserRepository;
import com.wawahei.quartzdemo.springbootquartz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: yanghailang
 * @create: 2020-12-22 17:34
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}