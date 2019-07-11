package com.learn.springcloud.serviceconsumer;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "post-service")
public interface HelloClient {
    @GetMapping("/hello")
    String hello();
}
