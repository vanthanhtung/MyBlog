package com.example.demo.service.postImageService;

import com.example.demo.model.PostImage;
import com.example.demo.repository.PostImageRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class PostImageServiceIml implements PostImageService {
    @Autowired
    PostImageRepository postImageRepository;

    @Override
    public Iterable<PostImage> findAll() {
        return postImageRepository.findAll();
    }

    @Override
    public Optional<PostImage> findById(Long id) {
        return postImageRepository.findById(id);
    }

    @Override
    public PostImage save(PostImage postImage) {
        return postImageRepository.save(postImage);
    }

    @Override
    public void remove(Long id) {
        postImageRepository.deleteById(id);
    }
}
