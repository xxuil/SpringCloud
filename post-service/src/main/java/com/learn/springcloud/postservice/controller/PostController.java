package com.learn.springcloud.postservice.controller;


import com.learn.springcloud.postservice.pojo.Post;
import com.learn.springcloud.postservice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    PostService ps;

    @RequestMapping("/listPost")
    public Object list() throws InterruptedException{
        Thread.sleep(5000L);
        return ps.getAll();
    }

    @RequestMapping("/p/{pid}")
    public Object get(@PathVariable("pid") int pid) {
        return ps.get(pid);
    }

    @RequestMapping(value = "/post/add", method = RequestMethod.POST)
    public void add(@RequestBody Post post) {
        ps.add(post);
    }
}
