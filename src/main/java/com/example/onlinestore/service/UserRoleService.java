package com.example.onlinestore.service;

import com.example.onlinestore.entity.UserRole;

import java.util.List;

public interface UserRoleService {
    UserRole createUserRole(UserRole userRole);
    List<UserRole> getAll();
    UserRole getById(Long id);
    UserRole updateUserRole(UserRole userRole);
    UserRole deleteById(Long id);
}
