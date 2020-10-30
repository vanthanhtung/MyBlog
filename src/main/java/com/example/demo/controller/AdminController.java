package com.example.demo.controller;

import com.example.demo.model.Role;
import com.example.demo.service.appUserService.AppUserService;
import com.example.demo.service.roleService.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private RoleService roleService;

    @GetMapping("")
    public ModelAndView test1(){
        ModelAndView modelAndView = new ModelAndView("adminPage");
        modelAndView.addObject("listUsers",appUserService.getAllByRoleId((long) 2));
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
