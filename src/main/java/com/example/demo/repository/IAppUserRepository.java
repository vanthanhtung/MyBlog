package com.example.demo.repository;

import com.example.demo.model.AppUser;
import com.example.demo.model.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface IAppUserRepository extends CrudRepository<AppUser, Long> {

    AppUser findByName(String username);

    Iterable<AppUser> getAllByRoleId(Long id);
}
