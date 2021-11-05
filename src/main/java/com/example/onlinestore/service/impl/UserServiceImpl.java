package com.example.onlinestore.service.impl;

import antlr.StringUtils;
import com.example.onlinestore.entity.User;
import com.example.onlinestore.entity.UserRole;
import com.example.onlinestore.model.UserAuthModel;
import com.example.onlinestore.repository.UserRepository;
import com.example.onlinestore.repository.UserRoleRepository;
import com.example.onlinestore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRoleRepository userRoleRepository;
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        System.out.println(encodedPassword);
        user.setPassword(encodedPassword);
        userRepository.save(user);

        UserRole userRole = new UserRole();
        userRole.setRoleName("ROLE_USER");
        userRole.setUser(user);
        userRoleRepository.save(userRole);

        return user;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User updateClient(User user) {
        User userForUpdate = getById(user.getId());

        if (user.getCreateDate() != null) userForUpdate.setCreateDate(user.getCreateDate());
        if (user.getFullName() != null) userForUpdate.setFullName(user.getFullName());
        if (user.getPassword() != null) userForUpdate.setPassword(user.getPassword());
        if (user.getIsActive() != null) userForUpdate.setIsActive(user.getIsActive());

        return userRepository.save(userForUpdate);
    }

    @Override
    public User deleteById(Long id) {
        User userForDelete = getById(id);
        if (userForDelete != null) userRepository.delete(userForDelete);

        return userForDelete;
    }

    @Override
    public User getCurrentUser() {
        String fullName = SecurityContextHolder.getContext().getAuthentication().getName();
        return getByFullName(fullName);
    }

    @Override
    public User getByFullName(String fullName) {
        return userRepository.getByFullName(fullName).orElse(null);
    }

    @Override
    public String getBasicAuthHeaderByAuthModel(UserAuthModel userAuthModel) {
        User user = userRepository.getByFullName(userAuthModel.getFullName())
                .orElseThrow( () -> new IllegalArgumentException("Неверный логин или пароль"));

        String userEncodedPassword = user.getPassword();

        boolean isPasswordCorrect = passwordEncoder.matches(userAuthModel.getPassword(), userEncodedPassword);

        if (!isPasswordCorrect) throw  new IllegalArgumentException("Неверный логин или пароль");

        String fullNamePasswordPair = userAuthModel.getFullName() + ":" + userAuthModel.getPassword();

        String authHeader = new String(Base64.getEncoder().encode(fullNamePasswordPair.getBytes()));

        return "Basic " + authHeader;
    }
}
