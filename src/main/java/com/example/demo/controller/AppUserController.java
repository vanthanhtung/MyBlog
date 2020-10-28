package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class AppUserController {
    @GetMapping
    public ModelAndView test(){
        ModelAndView modelAndView = new ModelAndView("test");
        return modelAndView;
    }
}
