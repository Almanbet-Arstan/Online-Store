package com.example.onlinestore.repository;

import com.example.onlinestore.entity.UserProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProductRepository extends JpaRepository<UserProduct, Long> {
}