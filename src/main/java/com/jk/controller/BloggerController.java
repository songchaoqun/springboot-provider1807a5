package com.jk.controller;

import com.jk.model.Blogger;
import com.jk.service.BloggerService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("blogger")
public class BloggerController {

    @Resource
    private BloggerService bloggerService;

    @RequestMapping("login")
    @ResponseBody
    public String login(Blogger blogger, HttpSession session){
        Blogger blogger1 = bloggerService.getByUsername(blogger.getUsername());
        // 验证用户名是否正确
        if(blogger1==null){
            return "用户名错误";
        }
        //验证密码是否正确
        if(!blogger1.getPassword().equals(blogger.getPassword())){
            return "密码错误";
        }
        // 存入session
        session.setAttribute("blogger",blogger1);
        return "登录成功";
    }



}
