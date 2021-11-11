package com.example.onlinestore.service;

import com.example.onlinestore.entity.UserProduct;

import java.util.List;

public interface UserProductService {
    UserProduct createUserProduct(UserProduct userProduct);
    List<UserProduct> getAll();
    UserProduct getById(Long id);
    UserProduct updateUserProduct(UserProduct userProduct);
    UserProduct deleteById(Long id);
}
