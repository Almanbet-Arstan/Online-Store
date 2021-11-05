package com.example.onlinestore.controller;

import com.example.onlinestore.entity.User;
import com.example.onlinestore.model.ResponseMessage;
import com.example.onlinestore.model.UserAuthModel;
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
    public User getById(@PathVariable Long id){
        return userService.getById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @PostMapping("/sign-in")
    public ResponseMessage<String> getAuthHead(@RequestBody UserAuthModel userAuthModel){
        ResponseMessage<String> responseMessage = new ResponseMessage<>();
        try {
            String authHeader = userService.getBasicAuthHeaderByAuthModel(userAuthModel);
            return responseMessage.prepareSuccessMessage(authHeader);
        } catch (IllegalArgumentException e){
            return responseMessage.prepareFailMessage(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        } catch (Exception e){
            return responseMessage.prepareFailMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
        }
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
