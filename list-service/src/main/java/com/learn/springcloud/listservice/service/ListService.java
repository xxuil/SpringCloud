package com.learn.springcloud.listservice.service;

import com.learn.springcloud.listservice.client.PostClient;
import com.learn.springcloud.listservice.pojo.Post;
import com.learn.springcloud.listservice.utils.Redis.ListRedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListService {
    @Autowired
    PostClient postClient;

    @Autowired
    ListRedisUtil<Post> redisUtil;

    public List<Post> timeList() {
        if(redisUtil.size("time") == 0) {
            return updateTimeList();
        }

        return redisUtil.get("time", 0, redisUtil.size("time"));
    }

    public List<Post> updateTimeList() {
        List<Post> list = postClient.list();

        if(list == null){
            return null;
        }
        redisUtil.get("time");
        redisUtil.set("time", list);
        return list;
    }

    public List<Post> viewList() {
        return null;
    }

    public List<Post> replyList() {
        return null;
    }
}
