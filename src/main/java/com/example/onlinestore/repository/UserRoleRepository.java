package com.example.onlinestore.repository;

import com.example.onlinestore.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository  extends JpaRepository<UserRole, Long> {
}
