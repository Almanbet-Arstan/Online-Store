package com.example.onlinestore.service;

import com.example.onlinestore.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    List<User> getAll();
    User getById(Long id);
    User updateClient(User user);
    User deleteById(Long id);
}
