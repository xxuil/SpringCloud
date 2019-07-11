package com.learn.springcloud.postservice.controller;


import com.netflix.appinfo.EurekaInstanceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    protected Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private EurekaInstanceConfig eurekaInstanceConfig;

    @Value("${server.port}")
    private int serverPort = 0;

    @GetMapping("/hello")
    public String hello() {
        this.logger.info("/hello, instanceId: " + eurekaInstanceConfig.getInstanceId()
                 + "host: " + eurekaInstanceConfig.getHostName(false));
        return "Hello, Spring Cloud from port: " + String.valueOf(serverPort);
    }
}
