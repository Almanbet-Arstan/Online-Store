package com.example.onlinestore.boot;

import com.example.onlinestore.entity.User;
import com.example.onlinestore.entity.UserRole;
import com.example.onlinestore.repository.UserRoleRepository;
import com.example.onlinestore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartRunner implements CommandLineRunner {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private UserService userService;


    @Override
    public void run(String... args) throws Exception {
        User admin = new User();
        admin.setFullName("Алманбет Тотоев");
        admin.setPassword("12345678");
        admin.setIsActive(1L);
        userService.createUser(admin);
    }
}
