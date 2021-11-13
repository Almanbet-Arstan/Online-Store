package com.example.onlinestore.service;

import com.example.onlinestore.entity.Product;
import com.example.onlinestore.entity.UserProduct;
import com.example.onlinestore.model.UserProductModel;

import java.util.List;

public interface UserProductService {
    UserProduct createUserProduct(UserProductModel userProductModel);
    List<UserProduct> getAll();
    UserProduct getById(Long id);
    UserProduct updateUserProduct(UserProduct userProduct);
    UserProduct deleteById(Long id);
    List<Product> findUserProductsByOrderId(Long id);

}
