package com.example.demo.repository;

import com.example.demo.model.AppUser;
import com.example.demo.model.Post;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PostRepository extends PagingAndSortingRepository<Post, Long> {
    Iterable<Post> getAllByAppUser(AppUser appUser);
}
