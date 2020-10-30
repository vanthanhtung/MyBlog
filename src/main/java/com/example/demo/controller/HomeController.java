package com.example.demo.controller;

import com.example.demo.model.AppUser;
import com.example.demo.model.Role;
import com.example.demo.service.appUserService.AppUserService;
import com.example.demo.service.roleService.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Controller
public class HomeController {
    @Autowired
    private AppUserService appUserService;

    @Autowired
    private RoleService roleService;

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
        appUserService.save(appUser);
        modelAndView.addObject("appUser",appUser);
        return modelAndView;
    }
    @GetMapping("/")
    public ModelAndView showUser() {
        ModelAndView modelAndView = new ModelAndView("/test/showUser");
        Iterable<AppUser> appUsers= appUserService.findAll();
        modelAndView.addObject("appUser",appUsers);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/test/createUser");
        modelAndView.addObject("appUser", new AppUser());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView createNewProduct(@ModelAttribute AppUser appUserForm){

        MultipartFile file = appUserForm.getImgFile();
        String image = file.getOriginalFilename();
        AppUser appUser = new AppUser();
        appUser.setName(appUserForm.getName());
        appUser.setAvatar(image);
        appUser.setCover(appUserForm.getCover());
        appUser.getDateOfBirth(appUserForm.getDateOfBirth());
        appUser.getEmail(appUserForm.getEmail());
        appUser.setGender(appUserForm.getGender());
        appUser.setIntroduction(appUserForm.getIntroduction());
        appUser.setJob(appUserForm.getJob());
        appUserService.save(appUser);
        ModelAndView modelAndView = new ModelAndView("/test/showUser");
        modelAndView.addObject("appUser", new AppUser());
        return modelAndView;
    }
}
