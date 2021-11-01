package com.example.onlinestore.controller;

import com.example.onlinestore.entity.User;
import com.example.onlinestore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id){
        return userService.getById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @PutMapping
    public User updateClient(@RequestBody User user){
        return userService.updateClient(user);
    }

    @DeleteMapping("/{id}")
    public User deleteById(@PathVariable Long id){
        return userService.deleteById(id);
    }
}
