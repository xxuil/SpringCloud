package com.learn.springcloud.listservice.controller;

import com.learn.springcloud.listservice.pojo.Post;
import com.learn.springcloud.listservice.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ListController {
    @Autowired
    ListService listService;

    @GetMapping("/recent")
    public Object timeList() {
        List<Post> list = listService.timeList();
        if(list == null) {
            return "fallback";
        }

        return list;
    }

    @GetMapping("/update")
    public Object update() {
        if(listService.updateTimeList() == null)
            return "fallback";
        return "update success";
    }
}
