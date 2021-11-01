package com.example.onlinestore.controller;

import com.example.onlinestore.entity.Delivery;
import com.example.onlinestore.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/delivery")
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;

    @GetMapping
    public List<Delivery> getAll(){
        return deliveryService.getAll();
    }

    @GetMapping("/{id}")
    public Delivery getById(@PathVariable Long id){
        return deliveryService.getById(id);
    }

    @PostMapping
    public Delivery createDelivery(@RequestBody Delivery delivery){
        return deliveryService.createDelivery(delivery);
    }

    @PutMapping
    public Delivery updateDelivery(@RequestBody Delivery delivery){
        return deliveryService.updateDelivery(delivery);
    }

    @DeleteMapping("/{id}")
    public Delivery deleteById(@PathVariable Long id){
        return deliveryService.deleteById(id);
    }
}
