package com.example.onlinestore.model;

import com.example.onlinestore.entity.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserModel {
    private String fullName;
    private String password;
    private Long isActive;
    private Long userRoleId;
}
