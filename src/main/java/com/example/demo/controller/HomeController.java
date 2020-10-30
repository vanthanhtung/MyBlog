package com.example.demo.controller;

import com.example.demo.model.AppUser;
import com.example.demo.model.Role;
import com.example.demo.service.appUserService.AppUserService;
import com.example.demo.service.roleService.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;


@Controller
public class HomeController {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private RoleService roleService;

    @GetMapping("khongcoquyen")
    public String accessDenied(){
        return "khongcoquyen";
    }

    @GetMapping("/")
    public ModelAndView login1(){
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
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
        Optional<Role> role = roleService.findById((long)2);
        appUser.setRole(role.get());
        appUser.setActive(true);
        appUserService.save(appUser);
        modelAndView.addObject("appUser",appUser);
        return modelAndView;
    }
}
