package com.example.onlinestore.service;

import com.example.onlinestore.entity.User;
import com.example.onlinestore.model.UserAuthModel;

import java.util.List;

public interface UserService {
    User createUser(User user);
    List<User> getAll();
    User getById(Long id);
    User updateClient(User user);
    User deleteById(Long id);
    User getCurrentUser();
    User getByFullName(String fullName);
    String getBasicAuthHeaderByAuthModel(UserAuthModel userAuthModel);
}
