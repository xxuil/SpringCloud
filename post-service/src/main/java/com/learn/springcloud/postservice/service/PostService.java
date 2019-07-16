package com.learn.springcloud.postservice.service;


import com.learn.springcloud.postservice.mapper.PostMapper;
import com.learn.springcloud.postservice.pojo.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    PostMapper postMapper;

    public void add(Post p) {
        postMapper.add(p);
    }

    public Post get(int pid) {
        postMapper.incrementView(pid);
        return postMapper.get(pid);
    }

    public List<Post> getAll() {
        return postMapper.findAll();
    }
}
