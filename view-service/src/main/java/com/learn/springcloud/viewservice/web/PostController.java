package com.learn.springcloud.viewservice.web;

import com.learn.springcloud.viewservice.pojo.Post;
import com.learn.springcloud.viewservice.pojo.Reply;
import com.learn.springcloud.viewservice.pojo.User;
import com.learn.springcloud.viewservice.service.PostService;
import com.learn.springcloud.viewservice.service.ReplyService;
import com.learn.springcloud.viewservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PostController {
    @Autowired
    PostService postService;

    @Autowired
    UserService userService;

    @Autowired
    ReplyService replyService;

    @RequestMapping("/")
    public Object toMain(HttpSession session, Model m) {
        if(session.getAttribute("userId") == null) {
            return "/login";
        }
        List<Post> posts = postService.toMain();
        int uid = (int) session.getAttribute("userId");
        User user = userService.getByUid(uid);
        m.addAttribute("user", user);
        m.addAttribute("posts", posts);
        return "posts";
    }

    @RequestMapping("/viewPost/{pid}")
    public Object toPost(@PathVariable("pid") int pid, HttpSession session, Model m) {
        if(session.getAttribute("userId") == null) {
            return "/login";
        }
        Post post = postService.toPost(pid);
        List<Reply> replies = replyService.getReplies(pid);
        m.addAttribute("post", post);
        m.addAttribute("replies", replies);
        int uid = (int) session.getAttribute("userId");
        User user = userService.getByUid(uid);
        m.addAttribute("user", user);
        return "view";
    }

    @RequestMapping("/addPost")
    public Object newPost() {
        return "add";
    }

    @RequestMapping("/newPost")
    public Object addPost(HttpServletRequest request, HttpSession session) {
        if(session.getAttribute("userId") == null) {
            return "redirect:/";
        }
        int uid = (int) session.getAttribute("userId");
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        Post p = new Post();
        p.setPid(0);
        p.setTitle(title);
        p.setContent(content);
        p.setUserId(uid);
        p.setTime(String.valueOf(System.currentTimeMillis()));
        p.setViewCount(0);
        p.setReplyCount(0);
        postService.addPost(p);

        return "redirect:/";
    }
}
