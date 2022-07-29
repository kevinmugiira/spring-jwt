package com.example.jwtwithamigos.service;


import com.example.jwtwithamigos.models.AppUser;
import com.example.jwtwithamigos.models.Role;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    AppUser saveUser(AppUser user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    AppUser getUser(String username);
    List<AppUser>getUsers();
}
