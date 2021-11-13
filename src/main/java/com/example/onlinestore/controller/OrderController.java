package com.example.onlinestore.controller;

import com.example.onlinestore.entity.Order;
import com.example.onlinestore.model.ItemsForBuyModel;
import com.example.onlinestore.model.OrderModel;
import com.example.onlinestore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAll(){
        return orderService.getAll();
    }

    @GetMapping("/{id}")
    public Order getById(@PathVariable Long id){
        return orderService.getById(id);
    }

    @PostMapping
    public Order createOrder(@RequestBody OrderModel orderModel){
        return orderService.createOrder(orderModel);
    }

    @PutMapping
    public Order updateOrder(@RequestBody Order order){
        return orderService.updateOrder(order);
    }

    @DeleteMapping("/{id}")
    public Order deleteById(@PathVariable Long id){
        return orderService.deleteById(id);
    }

    @PostMapping("/buy")
    public Order buyItems(@RequestBody ItemsForBuyModel itemsForBuyModel) {
        return orderService.buyItems(itemsForBuyModel);
    }
}
