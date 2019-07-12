package com.learn.springcloud.viewservice.service;

import com.learn.springcloud.viewservice.client.UserClient;
import com.learn.springcloud.viewservice.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserClient userClient;

    public void addUser(User user) {
        userClient.add(user);
    }

    public boolean login(String name, String password) {
        User user = new User();
        user.setUid(0);
        user.setUsername(name);
        user.setPassword(password);

        return userClient.login(user);
    }

    public User getByUid(int uid) {
        return userClient.getByUid(uid);
    }

    public User getByName(String name) {
        return userClient.getByName(name);
    }
}
