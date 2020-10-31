package com.example.demo.service.appUserService;

import com.example.demo.model.AppUser;
import com.example.demo.model.Role;
import com.example.demo.service.GeneralService;

import java.util.Optional;

public interface AppUserService extends GeneralService<AppUser> {

    AppUser getUserByUsername(String username);

    Iterable<AppUser> getAllByRoleId(Long id);

    AppUser getCurrentUser();
}
