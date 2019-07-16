package com.learn.springcloud.userservice.controller;

import com.learn.springcloud.userservice.pojo.User;
import com.learn.springcloud.userservice.service.LoginLogService;
import com.learn.springcloud.userservice.service.UserService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    LoginLogService loginLogService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void add(@RequestBody User u) {
        userService.addUser(u);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public boolean login(@RequestBody User user) {
        return userService.login(user.getUsername(), user.getPassword());
    }

    @RequestMapping("/{uid}")
    public User getByUid(@PathVariable("uid") int uid){
        return userService.get(uid);
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public User getByName(@RequestBody String name) {
        return userService.getByName(name);
    }

}
