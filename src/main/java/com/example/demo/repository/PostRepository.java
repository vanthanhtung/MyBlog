package com.example.demo.repository;

import com.example.demo.model.AppUser;
import com.example.demo.model.CommentPost;
import com.example.demo.model.Post;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {
//    Iterable<CommentPost> getAllByPost_id(Long id);
    Iterable<Post> getAllByAppUser(AppUser appUser);
}
