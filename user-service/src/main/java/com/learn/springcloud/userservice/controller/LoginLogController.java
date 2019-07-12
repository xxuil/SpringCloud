package com.learn.springcloud.userservice.controller;

import com.learn.springcloud.userservice.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class LoginLogController {
    @Autowired
    LoginLogService loginLogService;
}
