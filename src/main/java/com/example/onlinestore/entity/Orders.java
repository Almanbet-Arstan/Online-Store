package com.example.onlinestore.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @ManyToOne
    @ToString.Exclude
    private Integer clientsId;

    @Column
    private Date dateOfPlacement;

    @Column
    private Date dateOfCompletion;

    @Column
    @ManyToOne
    private Integer deliveryId;

    @Column
    private Integer priceOfDelivery;
}
