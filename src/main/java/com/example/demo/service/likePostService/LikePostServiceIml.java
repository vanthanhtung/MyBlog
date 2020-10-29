package com.example.demo.service.likePostService;

import com.example.demo.model.LikePost;
import com.example.demo.repository.LikePostRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class LikePostServiceIml implements LikePostService {
    @Autowired
    LikePostRepository likePostRepository;

    @Override
    public Iterable<LikePost> findAll() {
        return likePostRepository.findAll();
    }

    @Override
    public Optional<LikePost> findById(Long id) {
        return likePostRepository.findById(id);
    }

    @Override
    public LikePost save(LikePost likePost) {
        return likePostRepository.save(likePost);
    }

    @Override
    public void remove(Long id) {
        likePostRepository.deleteById(id);
    }
}
