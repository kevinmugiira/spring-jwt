package com.example.jwtwithamigos;

import com.example.jwtwithamigos.models.AppUser;
import com.example.jwtwithamigos.models.Role;
import com.example.jwtwithamigos.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class JwtWithAmigosApplication {

    public static void main(String[] args) {

        SpringApplication.run(JwtWithAmigosApplication.class, args);
    }


    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new AppUser(null, "John Travolta", "john", 72309374, "1234", new ArrayList<>()));
            userService.saveUser(new AppUser(null, "Blacko Maindrev", "bulako", 878925, "1234", new ArrayList<>()));
            userService.saveUser(new AppUser(null, "Bulawalo Konichuwa", "konich", 3897298, "1234", new ArrayList<>()));
            userService.saveUser(new AppUser(null, "Kipkemboi Underson", "kipunder", 983789, "1234", new ArrayList<>()));

            userService.addRoleToUser("john", "ROLE_USER");
            userService.addRoleToUser("john", "ROLE_MANAGER");
            userService.addRoleToUser("bulako", "ROLE_ADMIN");
            userService.addRoleToUser("konich", "ROLE_SUPER_ADMIN");
            userService.addRoleToUser("konich", "ROLE_ADMIN");
            userService.addRoleToUser("kipunder", "ROLE_MANAGER");
            userService.addRoleToUser("kipunder", "ROLE_USER");
        };
    }
}

