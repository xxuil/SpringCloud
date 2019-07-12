package com.learn.springcloud.viewservice.web;


import com.learn.springcloud.viewservice.pojo.User;
import com.learn.springcloud.viewservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public Object login() {
        return "login";
    }

    @RequestMapping("/register")
    public Object register() {
        return "register";
    }

    @RequestMapping("/user/check")
    public Object checkUser(HttpServletRequest request, HttpSession session) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean check = userService.login(username, password);

        if(check) {
            User u = userService.getByName(username);
            session.setAttribute("userId", u.getUid());
            session.setAttribute("username", username);

            return "redirect:/";
        }
        return "redirect:/";
    }

    @RequestMapping("/user/add")
    public Object addUser(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User u = new User();
        u.setUid(0);
        u.setUsername(username);
        u.setPassword(password);
        userService.addUser(u);
        return "redirect:/";
    }
}
