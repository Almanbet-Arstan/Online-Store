package com.example.onlinestore.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User extends BaseEntity{

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "password")
    private String password;

    @Column(name = "is_active")
    private Long isActive;

    @ManyToOne
    @JoinColumn(name = "user_role_id")
    private UserRole userRole;
}
