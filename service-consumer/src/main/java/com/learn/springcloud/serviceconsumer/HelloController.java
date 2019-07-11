package com.learn.springcloud.serviceconsumer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private HelloClient client;

    @RequestMapping("/hello")
    public String hello() {
        return client.hello();
    }
}
