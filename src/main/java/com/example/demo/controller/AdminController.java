package com.example.demo.controller;

import com.example.demo.model.AppUser;
import com.example.demo.model.Role;
import com.example.demo.service.appUserService.AppUserService;
import com.example.demo.service.roleService.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @ModelAttribute("roles")
    public Iterable<Role> roles (){
        return roleService.findAll();
    }

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

    @GetMapping("/blockUser/{id}")
    public ModelAndView blockUser(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("adminPage");
        Optional<AppUser> currentUser = appUserService.findById(id);
        AppUser currentUser1 = currentUser.get();
        Role role = roleService.getById((long) 3);
        currentUser1.setRole(role);
        currentUser1.setActive(false);
        appUserService.save(currentUser1);
        modelAndView.addObject("listUsers",appUserService.getAllByRoleId((long) 2));
        return modelAndView;
    }
}
