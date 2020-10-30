package com.example.demo.controller;

import com.example.demo.model.AppUser;
import com.example.demo.service.appUserService.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @GetMapping("")
    public ModelAndView home(@ModelAttribute String username){
        ModelAndView modelAndView = new ModelAndView("home");
        AppUser user = appUserService.getUserByUsername(username);
        if (user != null){
            modelAndView.addObject("user",user);
        }
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
