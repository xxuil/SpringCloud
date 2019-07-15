package com.learn.springcloud.viewservice.service;

import com.learn.springcloud.viewservice.client.PostClient;
import com.learn.springcloud.viewservice.pojo.Post;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    @Autowired
    PostClient postClient;

    @HystrixCommand(fallbackMethod = "fallback",
    commandProperties = {
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "1")
    }
    )
    public List<Post> toMain() {
    return postClient.list();
    }

    public Post toPost(int pid) {
        return postClient.get(pid);
    }

    public void addPost(Post post) {
        postClient.add(post);
    }

    public List<Post> fallback() {
        Post p =  new Post();
        p.setUserId(0);
        p.setTitle("fallback");
        p.setContent("fallback");
        p.setTime("fallback");
        p.setUserId(0);
        p.setReplyCount(0);
        p.setViewCount(0);

        List<Post> ps = new ArrayList<>();
        ps.add(p);
        return ps;
    }
}
