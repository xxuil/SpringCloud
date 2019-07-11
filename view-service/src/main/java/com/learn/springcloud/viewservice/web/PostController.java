package com.learn.springcloud.viewservice.web;

import com.learn.springcloud.viewservice.pojo.Post;
import com.learn.springcloud.viewservice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class PostController {
    @Autowired
    PostService postService;

    @RequestMapping("/")
    public Object toMain(Model model) {
        List<Post> ps = postService.toMain();
        model.addAttribute("posts", ps);
        return "posts";
    }
}
