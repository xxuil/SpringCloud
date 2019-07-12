package com.learn.springcloud.viewservice.client;

import com.learn.springcloud.viewservice.pojo.Reply;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient("REPLY-SERVICE")
public interface ReplyClient {
    @PostMapping("/addReply")
    void add(Reply reply);

    @GetMapping("/getReplies/{pid}")
    List<Reply> getReplies(@PathVariable("pid") int pid);
}
