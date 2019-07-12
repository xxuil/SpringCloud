package com.learn.springcloud.replyservice.controller;

import com.learn.springcloud.replyservice.pojo.Reply;
import com.learn.springcloud.replyservice.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReplyController {
    @Autowired
    ReplyService replyService;

    @RequestMapping(value = "/reply/add", method = RequestMethod.POST)
    public void add(@RequestBody Reply reply){
        replyService.addReply(reply);
    }


    @RequestMapping("/getReplies")
    public List<Reply> getReplies(@PathVariable("pid") int pid) {
        return replyService.getReplies(pid);
    }
}
