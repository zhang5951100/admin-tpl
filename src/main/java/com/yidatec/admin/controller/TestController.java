package com.yidatec.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping(value = {"/","index"})
    public String index(){
        return "index";
    }

    @GetMapping("/hello")
    public String hello(){

        return "hello";
    }

    @GetMapping("/login")
    public String login(){

        return "login";
    }


    @GetMapping("/admin")
    public String admin(Model model){

        model.addAttribute("title","标题");
        model.addAttribute("content","内容");
        model.addAttribute("extraInfo","你是admin");
        return "admin";
    }
}
