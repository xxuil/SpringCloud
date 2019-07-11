package com.learn.springcloud.viewservice.client;

import com.learn.springcloud.viewservice.pojo.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient("POST-SERVICE")
public interface PostClient {
    @GetMapping("/listPost")
    List<Post> list();

    @GetMapping(value = "/p/{pid}")
    Post get(@PathVariable("pid")int pid);

    @PostMapping("/post/add")
    void add(Post post);
}
