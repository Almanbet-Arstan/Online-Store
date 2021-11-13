package com.example.onlinestore.repository;

import com.example.onlinestore.entity.UserProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserProductRepository extends JpaRepository<UserProduct, Long> {
    List<UserProduct> findUserProductsByOrderId(Long id);
}