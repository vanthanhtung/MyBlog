package com.example.demo.service.postService;

import com.example.demo.model.AppUser;
import com.example.demo.model.CommentPost;
import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postService;

    @Override
    public Iterable<Post> findAll() {
        return postService.findAll();
    }

    @Override
    public Optional<Post> findById(Long id) {
        return postService.findById(id);
    }

    @Override
    public Post save(Post post) {
        return postService.save(post);
    }

    @Override
    public void remove(Long id) {
        postService.deleteById(id);
    }

    @Override
    public Iterable<Post> getAllByAppUser(AppUser user) {
        return postService.getAllByAppUser(user);
    }
}
