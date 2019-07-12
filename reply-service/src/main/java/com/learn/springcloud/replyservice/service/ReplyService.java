package com.learn.springcloud.replyservice.service;

import com.learn.springcloud.replyservice.mapper.ReplyMapper;
import com.learn.springcloud.replyservice.pojo.Reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyService {
    @Autowired
    ReplyMapper replyMapper;

    public void addReply(Reply reply) {
        replyMapper.add(reply);
    }

    public List<Reply> getReplies(int pid) {
        return replyMapper.findReplies(pid);
    }
}
