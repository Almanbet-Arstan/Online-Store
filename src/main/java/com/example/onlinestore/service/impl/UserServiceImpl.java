package com.example.onlinestore.service.impl;

import com.example.onlinestore.converter.UserConverter;
import com.example.onlinestore.entity.User;
import com.example.onlinestore.exception.ApiErrorException;
import com.example.onlinestore.exception.ApiFailException;
import com.example.onlinestore.model.UserAuthModel;
import com.example.onlinestore.model.UserModel;
import com.example.onlinestore.repository.UserRepository;
import com.example.onlinestore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public User createUser(UserModel userModel) {
        String encodedPassword = passwordEncoder.encode(userModel.getPassword());
        userModel.setPassword(encodedPassword);
        return userRepository.save(userConverter.convertFromModel(userModel));
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow( () -> new ApiFailException("Не удалось найти пользователя по id: " + id));
    }

    @Override
    public User updateClient(User user) {
        User userForUpdate = getById(user.getId());

        if (user.getCreateDate() != null) userForUpdate.setCreateDate(user.getCreateDate());
        if (user.getLogin() != null) userForUpdate.setLogin(user.getLogin());
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
        return getByLogin(fullName);
    }

    @Override
    public User getByLogin(String login) {
        return userRepository.getByLogin(login).orElseThrow( () -> new ApiFailException("Не удалось найти пользователя по login: " + login));
    }

    @Override
    public String getBasicAuthHeaderByAuthModel(UserAuthModel userAuthModel) {
        User user = userRepository.getByLogin(userAuthModel.getLogin())
                .orElseThrow( () -> new ApiFailException("Неверный логин или пароль"));

        String userEncodedPassword = user.getPassword();

        boolean isPasswordCorrect = passwordEncoder.matches(userAuthModel.getPassword(), userEncodedPassword);

        if (!isPasswordCorrect) throw  new ApiFailException("Неверный логин или пароль");

        String fullNamePasswordPair = userAuthModel.getLogin() + ":" + userAuthModel.getPassword();

        String authHeader = new String(Base64.getEncoder().encode(fullNamePasswordPair.getBytes()));

        return "Basic " + authHeader;
    }
}
