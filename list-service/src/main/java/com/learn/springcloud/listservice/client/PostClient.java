package com.learn.springcloud.listservice.client;


import com.learn.springcloud.listservice.pojo.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(value = "POST-SERVICE", fallback = PostFallback.class)
public interface PostClient {
    @GetMapping("/post/list")
    List<Post> list();

    @GetMapping(value = "/post/{pid}")
    Post get(@PathVariable("pid")int pid);

    @PostMapping("/post/add")
    void add(Post post);
}
