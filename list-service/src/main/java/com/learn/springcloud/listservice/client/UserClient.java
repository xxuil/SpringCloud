package com.learn.springcloud.listservice.client;

import com.learn.springcloud.listservice.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("USER-SERVICE")
public interface UserClient {
    @PostMapping("/user/add")
    void add(User user);

    @PostMapping("/user/login")
    boolean login(User user);

    @GetMapping("/user/{uid}")
    User getByUid(@PathVariable("uid")int uid);

    @PostMapping("/get")
    User getByName(String name);
}
