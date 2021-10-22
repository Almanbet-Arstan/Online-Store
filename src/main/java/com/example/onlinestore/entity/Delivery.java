package com.example.onlinestore.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "delivery")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String telephone;
}
