package com.example.demo.controller;

        import com.example.demo.model.AppUser;
        import com.example.demo.model.CommentPost;
        import com.example.demo.model.Post;
        import com.example.demo.service.appUserService.AppUserService;
        import com.example.demo.service.commentService.CommentPostService;
        import com.example.demo.service.postService.PostService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.*;
        import org.springframework.web.servlet.ModelAndView;

        import java.util.List;

@Controller
@RequestMapping("/users/timeline")
public class AppUserFreindController {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private PostService postService;

    @Autowired
    private CommentPostService commentPostService;

    @ModelAttribute("post")
    public Post newPost(){
        Post post = new Post();
        return post;
    }

    @ModelAttribute("listPost")
    public Iterable<Post> listPost(){
        Iterable<Post> listPost= postService.findAll();
        return listPost;
    }

    @ModelAttribute("myListPost")
    public Iterable<Post> MylistPost(){
        Iterable<Post> listPost = postService.getAllByAppUser(appUserService.getCurrentUser());
        return listPost;
    }

    @ModelAttribute("comment")
    public CommentPost newComment(){
        CommentPost comment = new CommentPost();
        return comment;
    }

    @ModelAttribute("user")
    public AppUser currenUser(){
        return appUserService.getCurrentUser();
    }

    @PostMapping("/creat/post")
    public ModelAndView homePost(@ModelAttribute("post") Post post){
        post.setAppUser(appUserService.getCurrentUser());
        postService.save(post);
        ModelAndView modelAndView = new ModelAndView("redirect:/users/timeline");
        return modelAndView;
    }


    @PostMapping("/creat/comment")
    public ModelAndView homeComment( @ModelAttribute("idPost") Long id,  @ModelAttribute("content") String content){
        ModelAndView modelAndView = new ModelAndView("redirect:/users/timeline");
        Post post = postService.findById(id).get();

        CommentPost commentPost = new CommentPost();//tạo comment lưu và database. rồi mới xét lại commment cho post
        commentPost.setContent(content);
        commentPost.setAppUser(appUserService.getCurrentUser());
        commentPost.setPost(post);
        commentPostService.save(commentPost);

        post.setCommentPosts((List<CommentPost>) commentPostService.getAllByPost(post));
        postService.save(post);

        return modelAndView;
    }


    @GetMapping()
    public ModelAndView home(@ModelAttribute String username){
        ModelAndView modelAndView = new ModelAndView("timeline");
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

