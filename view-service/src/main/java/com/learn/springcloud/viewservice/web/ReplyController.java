package com.learn.springcloud.viewservice.web;

import com.learn.springcloud.viewservice.pojo.Reply;
import com.learn.springcloud.viewservice.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ReplyController {
    @Autowired
    ReplyService replyService;

    @RequestMapping("/reply/add")
    public Object addReply(HttpServletRequest request, HttpSession session) {
        int postId = Integer.parseInt(request.getParameter("postId"));
        int userId = Integer.parseInt(request.getParameter("userId"));
        String content = request.getParameter("content");

        Reply r = new Reply();
        r.setRid(0);
        r.setContent(content);
        r.setPostId(postId);
        r.setUserId(userId);
        r.setTime(String.valueOf(System.currentTimeMillis()));
        replyService.addReply(r);

        return "redirect:/viewPost/" + postId;
    }
}
