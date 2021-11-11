package com.example.onlinestore.controller;

import com.example.onlinestore.entity.UserProduct;
import com.example.onlinestore.service.UserProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-product")
public class UserProductController {
    @Autowired
    private UserProductService userProductService;

    @GetMapping
    public List<UserProduct> getAll(){
        return userProductService.getAll();
    }

    @GetMapping("/{id}")
    public UserProduct getById(@PathVariable Long id){
        return userProductService.getById(id);
    }

    @PostMapping
    public UserProduct createUserProduct(@RequestBody UserProduct userProduct){
        return userProductService.createUserProduct(userProduct);
    }

    @PutMapping
    public UserProduct updateUserProduct(@RequestBody UserProduct userProduct){
        return userProductService.updateUserProduct(userProduct);
    }

    @DeleteMapping("/{id}")
    public UserProduct deleteById(@PathVariable Long id){
        return userProductService.deleteById(id);
    }
}
