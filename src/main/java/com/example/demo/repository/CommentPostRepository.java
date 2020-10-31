package com.example.demo.repository;

import com.example.demo.model.CommentPost;
import org.springframework.data.repository.CrudRepository;

public interface CommentPostRepository extends CrudRepository<CommentPost, Long> {

}
