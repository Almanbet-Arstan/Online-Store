package com.example.onlinestore.service;

import com.example.onlinestore.entity.Delivery;

import java.util.List;

public interface DeliveryService {
    Delivery createDelivery(Delivery delivery);
    List<Delivery> getAll();
    Delivery getById(Long id);
    Delivery updateDelivery(Delivery delivery);
    Delivery deleteById(Long id);
}
