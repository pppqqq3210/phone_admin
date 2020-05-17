package com.hopu.phone_admin.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class UserController {

    @PostMapping("login")
    public String login(String username, String password, HttpSession session){
        UsernamePasswordToken token = new UsernamePasswordToken();
        token.setUsername(username);
        token.setPassword(password.toCharArray());
        Subject subject = SecurityUtils.getSubject();
        if(!subject.isAuthenticated()){
            try {
                subject.login(token);
                session.setAttribute("username",username);
                return "redirect:/index.html";
            }catch (AuthenticationException ex){
                ex.printStackTrace();
            }
        }
        return "redirect:/login.html";
    }

    @RequiresPermissions("财务管理")
    @ResponseBody
    @RequestMapping("test")
    public String test(){
        return "hello";
    }
}