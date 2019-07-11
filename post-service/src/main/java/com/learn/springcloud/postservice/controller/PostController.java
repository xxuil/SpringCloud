package com.learn.springcloud.postservice.controller;


import com.learn.springcloud.postservice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    PostService ps;

    @RequestMapping("/")
    public Object toMain() {
        return ps.getAll();
    }

    @RequestMapping("/p/{pid}")
    public Object toPost(@PathVariable("pid") int pid) {
        return ps.get(pid);
    }

    @RequestMapping(value = "/post/add", method = RequestMethod.POST)
    public void addPost() {

    }
}
