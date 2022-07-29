package com.example.jwtwithamigos.repo;

import com.example.jwtwithamigos.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
