package com.learn.springcloud.listservice.client;

import com.learn.springcloud.listservice.pojo.Post;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostFallback implements PostClient{
    @Override
    public List<Post> list() {
        return null;
    }

    @Override
    public void add(Post post) {

    }

    @Override
    public Post get(int pid) {
        return null;
    }
}
