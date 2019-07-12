package com.learn.springcloud.userservice.controller;

import com.learn.springcloud.userservice.pojo.User;
import com.learn.springcloud.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/addUser")
    public void add(User u) {
        userService.addUser(u);
    }

    @RequestMapping("/loginUser")
    public boolean login(String name, String pwd) {
        return userService.login(name, pwd);
    }

    @RequestMapping("/getUser/{uid}")
    public User getByUid(@PathVariable("uid") int uid){
        return userService.get(uid);
    }

    @RequestMapping("/getUser/{name}")
    public User getByName(@PathVariable("name") String name) {
        return userService.getByName(name);
    }

}
