package com.example.demo.repository;

import com.example.demo.model.AppUser;
import com.example.demo.model.Role;
import org.springframework.data.repository.CrudRepository;


public interface IAppUserRepository extends CrudRepository<AppUser, Long> {

    AppUser findByName(String username);

    Iterable<AppUser> getAllByRoleId(Long id);

    Iterable<AppUser> getAllByRoleIsNotContaining(Long id);

    Iterable<AppUser> getAllByRoleOrRole(Role role1, Role role2);
}
