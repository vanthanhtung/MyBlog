package com.example.demo.service.appUserService;

import com.example.demo.model.AppUser;
import com.example.demo.service.GeneralService;

public interface AppUserService extends GeneralService<AppUser> {
    AppUser getUserByUsername(String username);
}
