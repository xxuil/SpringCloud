package com.learn.springcloud.viewservice.client;

import com.learn.springcloud.viewservice.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("USER-SERVICE")
public interface UserClient {
    @PostMapping("/addUser")
    void add(User user);

    @PostMapping("/loginUser")
    boolean login(User user);

    @GetMapping("/getUser/{uid}")
    User getByUid(@PathVariable("uid")int uid);

    @PostMapping("/getUserByName")
    User getByName(String name);
}
