package com.example.onlinestore.boot;

import com.example.onlinestore.entity.User;
import com.example.onlinestore.entity.UserRole;
import com.example.onlinestore.repository.UserRoleRepository;
import com.example.onlinestore.service.UserRoleService;
import com.example.onlinestore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartRunner implements CommandLineRunner {

    @Autowired
    private UserRoleService userRoleService;


    @Override
    public void run(String... args) throws Exception {

        UserRole admin = new UserRole();
        admin.setRoleName("ROLE_ADMIN");
        userRoleService.createUserRole(admin);
        UserRole client = new UserRole();
        client.setRoleName("ROLE_CLIENT");
        userRoleService.createUserRole(client);
    }
}
