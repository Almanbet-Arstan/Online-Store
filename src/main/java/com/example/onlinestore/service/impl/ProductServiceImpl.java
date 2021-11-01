package com.example.onlinestore.service.impl;

import com.example.onlinestore.entity.Product;
import com.example.onlinestore.repository.ProductRepository;
import com.example.onlinestore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product updateProduct(Product product) {
        Product productForUpdate = getById(product.getId());

        if (product.getCreateDate() != null) productForUpdate.setCreateDate(product.getCreateDate());
        if (product.getName() != null) productForUpdate.setName(product.getName());
        if (product.getPrice() != null) productForUpdate.setPrice(product.getPrice());

        return productRepository.save(productForUpdate);
    }

    @Override
    public Product deleteById(Long id) {
        Product productForDelete = getById(id);
        if (productForDelete != null) productRepository.delete(productForDelete);

        return productForDelete;
    }
}
