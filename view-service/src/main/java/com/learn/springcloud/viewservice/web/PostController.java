package com.learn.springcloud.viewservice.web;

import com.learn.springcloud.viewservice.pojo.Post;
import com.learn.springcloud.viewservice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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

    @RequestMapping("/viewPost/{pid}")
    public Object toPost(@PathVariable("pid") int pid, Model model) {
        Post post = postService.toPost(pid);
        List<Post> ps = new ArrayList<>();
        ps.add(post);
        model.addAttribute("posts", ps);
        return "view";
    }

    @RequestMapping("/addPost")
    public Object addPost() {
        Post post = new Post();
        post.setPid(0);
        post.setTitle("test_00");
        post.setContent("test_00");
        post.setUserId(1);
        post.setTime(String.valueOf(System.currentTimeMillis()));
        post.setViewCount(0);
        post.setReplyCount(0);
        postService.addPost(post);
        return "redirect:/";
    }
}
