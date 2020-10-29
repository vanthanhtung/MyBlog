package com.example.demo.repository;

import com.example.demo.model.LikePost;
import org.springframework.data.repository.CrudRepository;

public interface LikePostRepository extends CrudRepository<LikePost,Long> {
}
