package com.learn.springcloud.userservice.service;

import com.learn.springcloud.userservice.mapper.LoginLogMapper;
import com.learn.springcloud.userservice.pojo.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginLogService {
    @Autowired
    LoginLogMapper mapper;

    public void addLog(LoginLog log) {
        mapper.add(log);
    }
}
