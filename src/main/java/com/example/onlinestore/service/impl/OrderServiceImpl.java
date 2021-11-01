package com.example.onlinestore.service.impl;

import com.example.onlinestore.entity.Order;
import com.example.onlinestore.entity.Product;
import com.example.onlinestore.repository.OrderRepository;
import com.example.onlinestore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order getById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Order updateOrder(Order order) {
        Order orderForUpdate = getById(order.getId());

        if (order.getCreateDate() != null) orderForUpdate.setCreateDate(order.getCreateDate());
        if (order.getUser() != null) orderForUpdate.setUser(order.getUser());
        if (order.getDelivery() != null) orderForUpdate.setDelivery(order.getDelivery());
        if (order.getProducts() != null) orderForUpdate.setProducts(order.getProducts());

        return orderRepository.save(orderForUpdate);
    }

    @Override
    public Order deleteById(Long id) {
        Order orderForDelete = getById(id);
        if (orderForDelete != null) orderRepository.delete(orderForDelete);

        return orderForDelete;
    }
}
