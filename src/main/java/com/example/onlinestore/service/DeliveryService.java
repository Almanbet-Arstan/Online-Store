package com.example.onlinestore.service;

import com.example.onlinestore.entity.Delivery;
import com.example.onlinestore.model.DeliveryModel;

import java.util.List;

public interface DeliveryService {
    Delivery createDelivery(DeliveryModel deliveryModel);
    List<Delivery> getAll();
    Delivery getById(Long id);
    Delivery updateDelivery(Delivery delivery);
    Delivery deleteById(Long id);
}
