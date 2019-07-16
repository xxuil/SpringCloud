package com.learn.springcloud.listservice.client;

import com.learn.springcloud.listservice.pojo.Reply;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient("REPLY-SERVICE")
public interface ReplyClient {
    @PostMapping("/reply/add")
    void add(Reply reply);

    @GetMapping("/reply/get/{pid}")
    List<Reply> getReplies(@PathVariable("pid") int pid);
}
