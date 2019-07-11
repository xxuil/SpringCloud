package com.learn.springcloud.viewservice.service;

import com.learn.springcloud.viewservice.client.PostClient;
import com.learn.springcloud.viewservice.pojo.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    PostClient postClient;

    public List<Post> toMain() {
        return postClient.toMain();
    }
}
