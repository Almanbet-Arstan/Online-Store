package com.example.onlinestore.controller;

import com.example.onlinestore.entity.UserRole;
import com.example.onlinestore.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-role")
public class UserRoleController {
    @Autowired
    private UserRoleService userRoleService;

    @GetMapping
    public List<UserRole> getAll(){
        return userRoleService.getAll();
    }

    @GetMapping("/{id}")
    public UserRole getById(@PathVariable Long id){
        return userRoleService.getById(id);
    }

    @PostMapping
    public UserRole createUserRole(@RequestBody UserRole userRole){
        return userRoleService.createUserRole(userRole);
    }

    @PutMapping
    public UserRole updateUserRole(@RequestBody UserRole userRole){
        return userRoleService.updateUserRole(userRole);
    }

    @DeleteMapping("/{id}")
    public UserRole deleteById(@PathVariable Long id){
        return userRoleService.deleteById(id);
    }
}
