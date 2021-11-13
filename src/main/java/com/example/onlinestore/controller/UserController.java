package com.example.onlinestore.controller;

import com.example.onlinestore.entity.User;
import com.example.onlinestore.model.ResponseMessage;
import com.example.onlinestore.model.UserAuthModel;
import com.example.onlinestore.model.UserModel;
import com.example.onlinestore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/get-current")
    public User getCurrentUser(){
        return userService.getCurrentUser();
    }

    @GetMapping("/{id}")
    public ResponseMessage<User> getById(@PathVariable Long id){
        return new ResponseMessage<User>().prepareSuccessMessage(userService.getById(id));
    }

    @PostMapping
    public User createUser(@RequestBody UserModel userModel){
        return userService.createUser(userModel);
    }

    @PostMapping("/sign-in")
    public ResponseMessage<String> getAuthHead(@RequestBody UserAuthModel userAuthModel){
        ResponseMessage<String> responseMessage = new ResponseMessage<>();
        String authHeader = userService.getBasicAuthHeaderByAuthModel(userAuthModel);
        return responseMessage.prepareSuccessMessage(authHeader);
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
