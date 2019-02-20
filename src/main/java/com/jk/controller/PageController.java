package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class PageController {

    @RequestMapping("/toindex")
    public String toindex(){
        System.out.println(11111111);
        return "index";
    }

}
