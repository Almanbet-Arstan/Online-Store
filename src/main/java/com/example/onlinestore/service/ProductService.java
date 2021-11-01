package com.example.onlinestore.service;

import com.example.onlinestore.entity.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    List<Product> getAll();
    Product getById(Long id);
    Product updateProduct(Product product);
    Product deleteById(Long id);
}
