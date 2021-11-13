package com.example.onlinestore.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeliveryModel {
    private String address;

    private String phoneNumber;

    private Integer priceOfDelivery;

    private Long orderId;
}
