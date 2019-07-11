package com.learn.springcloud.userservice.service;


import com.learn.springcloud.userservice.mapper.UserMapper;
import com.learn.springcloud.userservice.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public class UserService {
    @Autowired
    UserMapper userMapper;

    public void addUser(User user) {
        userMapper.add(user);
    }


    public boolean login(String username, String password) {
        List<User> list = userMapper.check(username);
        if (list.isEmpty())
            return false;

        return list.get(0).getPassword().equals(password);
    }


    public User get(int uid) {
        return userMapper.get(uid);
    }


    public int getCount() {
        return userMapper.getUserCount();
    }


    public User getByName(String username) {
        return userMapper.check(username).get(0);
    }
}
