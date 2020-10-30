package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class AppUserController {
    @GetMapping("/test")
    public ModelAndView test(){
        ModelAndView modelAndView = new ModelAndView("homePage");
        return modelAndView;
    }

    @GetMapping
    public ModelAndView test2(){
        ModelAndView modelAndView = new ModelAndView("userPage");
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
