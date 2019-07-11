package com.learn.springcloud.userservice.controller;

import com.learn.springcloud.userservice.pojo.User;
import com.learn.springcloud.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    public void addUser(User u) {
        userService.addUser(u);
    }
}
