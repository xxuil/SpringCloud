package com.learn.springcloud.viewservice.service;


import com.learn.springcloud.viewservice.client.ReplyClient;
import com.learn.springcloud.viewservice.pojo.Reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyService {
    @Autowired
    ReplyClient replyClient;

    public void addReply(Reply reply) {
        replyClient.add(reply);
    }

    public List<Reply> getReplies(int pid) {
        return replyClient.getReplies(pid);
    }
}
