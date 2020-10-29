package com.example.demo.service.commentPostService;

import com.example.demo.model.CommentPost;
import com.example.demo.repository.CommentPostRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CommentPostServiceIml implements CommentPostService {
    @Autowired
    CommentPostRepository commentPostRepository;

    @Override
    public Iterable<CommentPost> findAll() {
        return commentPostRepository.findAll();
    }

    @Override
    public Optional<CommentPost> findById(Long id) {
        return commentPostRepository.findById(id);
    }

    @Override
    public CommentPost save(CommentPost commentPost) {
        return commentPostRepository.save(commentPost);
    }

    @Override
    public void remove(Long id) {
        commentPostRepository.deleteById(id);
    }
}
