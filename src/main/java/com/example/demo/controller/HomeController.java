package com.example.demo.controller;

import com.example.demo.model.AppUser;
import com.example.demo.model.Role;
import com.example.demo.service.appUserService.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    private IAppUserService appUserService;

    @GetMapping("/khongcoquyen")
    public String accessDenied(){
        return "khongcoquyen";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public ModelAndView showRegisterForm(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("appUser",new AppUser());
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView createNewUser(@ModelAttribute("appUser") AppUser appUser){
        ModelAndView modelAndView = new ModelAndView("/userPage");
        Role role = new Role((long) 2,"ROLE_USER");
        appUser.setRole(role);
        appUserService.save(appUser);
        modelAndView.addObject("appUser",appUser);
        return modelAndView;
    }
}
