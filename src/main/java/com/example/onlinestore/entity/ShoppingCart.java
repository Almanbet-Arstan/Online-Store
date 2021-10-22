package com.example.onlinestore.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "shopping_cart")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @ManyToOne
    @ToString.Exclude
    private Integer productsId;

    @Column
    @ManyToOne
    private Integer ordersId;

    @Column
    private Integer price;

    @Column
    private Integer quantity;
}
