package com.example.onlinestore.repository;

import com.example.onlinestore.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
