package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class AppUserController {
    @GetMapping("/test")
    public ModelAndView test(){
        ModelAndView modelAndView = new ModelAndView("test");
        return modelAndView;
    }

    @GetMapping("/admin")
    public ModelAndView test1(){
        ModelAndView modelAndView = new ModelAndView("admin");
        return modelAndView;
    }

    @GetMapping("/user")
    public ModelAndView test2(){
        ModelAndView modelAndView = new ModelAndView("user");
        return modelAndView;
    }

    @GetMapping("/khongcoquyen")
    public String accessDenied(){
        return "khongcoquyen";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
