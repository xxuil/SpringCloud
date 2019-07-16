package com.learn.springcloud.postservice.controller;


import com.learn.springcloud.postservice.pojo.Post;
import com.learn.springcloud.postservice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostService ps;

    @RequestMapping("/list")
    public Object list() {
        return ps.getAll();
    }

    @RequestMapping("/{pid}")
    public Object get(@PathVariable("pid") int pid) {
        return ps.get(pid);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void add(@RequestBody Post post) {
        ps.add(post);
    }
}
