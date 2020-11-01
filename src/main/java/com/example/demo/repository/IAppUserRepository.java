package com.example.demo.repository;

import com.example.demo.model.AppUser;
import org.springframework.data.repository.CrudRepository;


public interface IAppUserRepository extends CrudRepository<AppUser, Long> {

    AppUser findByName(String username);

    Iterable<AppUser> getAllByRoleId(Long id);

    Iterable<AppUser> getAllByRoleIsNotContaining(Long id);

    Iterable<AppUser> getAllByNameIsContaining(String name);
}
