package com.example.demo.controller;

import com.example.demo.model.AppUser;
import com.example.demo.service.appUserService.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class AppUserController {
    @Autowired
    AppUserService appUserService;

    @GetMapping("/test")
    public ModelAndView test() {
        ModelAndView modelAndView = new ModelAndView("homePage");
        return modelAndView;
    }

    @GetMapping
    public ModelAndView test2() {
        ModelAndView modelAndView = new ModelAndView("userPage");
        return modelAndView;
    }


}
