package com.ysynzehao.service.impl;

import com.ysynzehao.dao.UserRepository;
import com.ysynzehao.entry.User;
import com.ysynzehao.redis.service.JRedisService;
import com.ysynzehao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2017/5/4.
 */
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JRedisService jRedisService;

    //@Cacheable(value = "usercache",keyGenerator = "wiselyKeyGenerator")
    @Override
    public List<User> getUserList() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUser(long id) {
        User user = jRedisService.get("user" + id, User.class);
        if (user == null) {
            System.out.println("--------------------------------------");
            user = userRepository.findOne(id);
            jRedisService.set("user" + id, user, 10);
        }
        return user;
    }
}
