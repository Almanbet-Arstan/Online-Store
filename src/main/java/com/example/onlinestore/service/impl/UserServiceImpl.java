package com.example.onlinestore.service.impl;

import com.example.onlinestore.entity.User;
import com.example.onlinestore.repository.UserRepository;
import com.example.onlinestore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
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
        if (user.getStatus() != null) userForUpdate.setStatus(user.getStatus());

        return userRepository.save(userForUpdate);
    }

    @Override
    public User deleteById(Long id) {
        User userForDelete = getById(id);
        if (userForDelete != null) userRepository.delete(userForDelete);

        return userForDelete;
    }
}
