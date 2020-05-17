package com.hopu.phone_admin.controller;

import com.hopu.phone_admin.entity.Module;
import com.hopu.phone_admin.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * 页面访问控制器
 */
@Controller
public class PageController {

    @RequestMapping("index.html")
    public String index(){
//        model.addAttribute("msg","Hello World!!");
//        List<User> users = new ArrayList<>();
//        User user1 = new User();
//        user1.setUserName("张三");
//        users.add(user1);
//        User user2 = new User();
//        user2.setUserName("李三");
//        users.add(user2);
//        model.addAttribute("users",users);
        return "index";
    }

    @RequestMapping("login.html")
    public String login(){
        return "login";
    }

    @RequestMapping("failed.html")
    public String failed(){
        return "failed";
    }
}