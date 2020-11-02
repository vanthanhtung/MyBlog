package com.example.demo.service.postService;

import com.example.demo.model.AppUser;
import com.example.demo.model.CommentPost;
import com.example.demo.model.Post;
import com.example.demo.service.GeneralService;
import javafx.geometry.Pos;
import org.springframework.data.domain.Sort;

public interface PostService extends GeneralService<Post> {
    Iterable<Post> getAllByAppUser(AppUser user);
}
