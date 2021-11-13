package com.example.onlinestore.service;

import com.example.onlinestore.entity.Order;
import com.example.onlinestore.model.ItemsForBuyModel;
import com.example.onlinestore.model.OrderModel;

import java.util.List;

public interface OrderService {
    Order createOrder(OrderModel orderModel);
    List<Order> getAll();
    Order getById(Long id);
    Order updateOrder(Order order);
    Order deleteById(Long id);
    Order buyItems(ItemsForBuyModel itemsForBuyModel);
}
