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

    public List<Post> toMain() {
        return postClient.list();
    }

    public Post toPost(int pid) {
        return postClient.get(pid);
    }

    public void addPost(Post post) {
        postClient.add(post);
    }
}
