package com.example.demo.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.demo.model.AppUser;
import com.example.demo.model.Post;
import com.example.demo.service.appUserService.AppUserService;
import com.example.demo.service.postService.PostService;
import org.cloudinary.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.nio.file.Files;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/users")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private PostService postService;

    String mCloudName = "dnulbp9wi";
    String mApiKey = "388747591265657";
    String mApiSecret = "QrSQljoMltB5OgDmxQM81UBSB-0";

    @ModelAttribute("post")
    public Post newPost(){
        Post post = new Post();
        return post;
    }

    @GetMapping("/avatar")
    public ModelAndView uploadImage(@ModelAttribute AppUser user) {
        ModelAndView modelAndView = new ModelAndView("home");
        MultipartFile avatarFile = user.getAvatarFile();
        Cloudinary c = new Cloudinary("cloudinary://" + mApiKey + ":" + mApiSecret + "@" + mCloudName);
        try {
            File avFile = Files.createTempFile("temp", avatarFile.getOriginalFilename()).toFile();
            avatarFile.transferTo(avFile);
            Map responseAV = c.uploader().upload(avFile, ObjectUtils.emptyMap());
            JSONObject jsonAV = new JSONObject(responseAV);
            String urlAV = jsonAV.getString("url");
            user.setAvatar(urlAV);
            appUserService.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelAndView;
    }

    @ModelAttribute("listPost")
    public Iterable<Post> listPost(){
        Iterable<Post> listPost= postService.findAll();
        return listPost;
    }

    @ModelAttribute("user")
    public AppUser currenUser(){
        return appUserService.getCurrentUser();
    }

    @PostMapping("/creat/post")
    public ModelAndView homePost(@ModelAttribute("post") Post post){
        post.setAppUser(appUserService.getCurrentUser());
        postService.save(post);
        ModelAndView modelAndView = new ModelAndView("redirect:/users");
        return modelAndView;
    }

    @GetMapping()
    public ModelAndView home(@ModelAttribute String username){
        ModelAndView modelAndView = new ModelAndView("home");
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

    @GetMapping("/trangchu")
    public String trangchu(){
        return "timeline";
    }
}
