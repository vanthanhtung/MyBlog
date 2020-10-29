package com.example.demo.repository;

import com.example.demo.model.AppUser;
import org.springframework.data.repository.CrudRepository;

public interface AppUserRepository extends CrudRepository<AppUser, Long> {
    AppUser findByName(String username);
}
