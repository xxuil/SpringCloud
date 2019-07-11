package com.learn.springcloud.viewservice.client;

import com.learn.springcloud.viewservice.pojo.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("POST-SERVICE")
public interface PostClient {
    @GetMapping("/")
    List<Post> toMain();

    @GetMapping(value = "/p/{pid}")
    Post toPost(@PathVariable("pid")int pid);
}
