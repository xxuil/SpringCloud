package com.learn.springcloud.userservice.controller;

import com.learn.springcloud.userservice.pojo.User;
import com.learn.springcloud.userservice.service.LoginLogService;
import com.learn.springcloud.userservice.service.UserService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    LoginLogService loginLogService;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public void add(@RequestBody User u) {
        userService.addUser(u);
    }

    @RequestMapping(value = "/loginUser", method = RequestMethod.POST)
    public boolean login(@RequestBody User user) {
        return userService.login(user.getUsername(), user.getPassword());
    }

    @RequestMapping("/getUser/{uid}")
    public User getByUid(@PathVariable("uid") int uid){
        return userService.get(uid);
    }

    @RequestMapping(value = "/getUserByName", method = RequestMethod.POST)
    public User getByName(@RequestBody String name) {
        return userService.getByName(name);
    }

}
