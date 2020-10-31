package com.example.demo.repository;

import com.example.demo.model.CommentPost;
import com.example.demo.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
//    Iterable<CommentPost> getAllByPost_id(Long id);
}
