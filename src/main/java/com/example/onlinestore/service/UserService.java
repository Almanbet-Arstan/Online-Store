package com.example.onlinestore.service;

import com.example.onlinestore.entity.User;
import com.example.onlinestore.model.UserAuthModel;
import com.example.onlinestore.model.UserModel;

import java.util.List;

public interface UserService {
    User createUser(UserModel userModel);
    List<User> getAll();
    User getById(Long id);
    User updateClient(User user);
    User deleteById(Long id);
    User getCurrentUser();
    User getByLogin(String login);
    String getBasicAuthHeaderByAuthModel(UserAuthModel userAuthModel);
}
