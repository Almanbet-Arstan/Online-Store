package com.example.onlinestore.service.impl;

import com.example.onlinestore.entity.UserProduct;
import com.example.onlinestore.entity.UserProduct;
import com.example.onlinestore.entity.UserProduct;
import com.example.onlinestore.repository.UserProductRepository;
import com.example.onlinestore.service.UserProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserProductServiceImpl implements UserProductService {

    @Autowired
    UserProductRepository userProductRepository;


    @Override
    public UserProduct createUserProduct(UserProduct userProduct) {
        return userProductRepository.save(userProduct);
    }

    @Override
    public List<UserProduct> getAll() {
        return userProductRepository.findAll();
    }

    @Override
    public UserProduct getById(Long id) {
        return userProductRepository.findById(id).orElse(null);
    }

    @Override
    public UserProduct updateUserProduct(UserProduct userProduct) {
        UserProduct userProductForUpdate = getById(userProduct.getId());

        if (userProduct.getCreateDate() != null) userProductForUpdate.setCreateDate(userProduct.getCreateDate());
        if (userProduct.getUser() != null) userProductForUpdate.setUser(userProduct.getUser());
        if (userProduct.getProduct() != null) userProductForUpdate.setProduct(userProduct.getProduct());
        if (userProduct.getOrder() != null) userProductForUpdate.setOrder(userProduct.getOrder());

        return userProductRepository.save(userProductForUpdate);
    }

    @Override
    public UserProduct deleteById(Long id) {
        UserProduct userProductForDelete = getById(id);
        if (userProductForDelete != null) userProductRepository.delete(userProductForDelete);

        return userProductForDelete;
    }
}
