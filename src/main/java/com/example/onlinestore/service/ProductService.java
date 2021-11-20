package com.example.onlinestore.service;

import com.example.onlinestore.entity.Product;
import com.example.onlinestore.model.ProductModel;

import java.util.List;

public interface ProductService {
    Product createProduct(ProductModel productModel);
    List<Product> getAll();
    Product getById(Long id);
    Product updateProduct(Product product);
    Product deleteById(Long id);
}
