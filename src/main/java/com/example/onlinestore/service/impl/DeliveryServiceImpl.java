package com.example.onlinestore.service.impl;

import com.example.onlinestore.converter.DeliveryConverter;
import com.example.onlinestore.entity.Delivery;
import com.example.onlinestore.model.DeliveryModel;
import com.example.onlinestore.repository.DeliveryRepository;
import com.example.onlinestore.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryServiceImpl implements DeliveryService {
    @Autowired
    private DeliveryRepository deliveryRepository;

    @Autowired
    private DeliveryConverter deliveryConverter;

    @Override
    public Delivery createDelivery(DeliveryModel deliveryModel) {
        return deliveryRepository.save(deliveryConverter.convertFromModel(deliveryModel));
    }

    @Override
    public List<Delivery> getAll() {
        return deliveryRepository.findAll();
    }

    @Override
    public Delivery getById(Long id) {
        return deliveryRepository.findById(id).orElse(null);
    }

    @Override
    public Delivery updateDelivery(Delivery delivery) {
        Delivery deliveryForUpdate = getById(delivery.getId());

        if (delivery.getCreateDate() != null) deliveryForUpdate.setCreateDate(delivery.getCreateDate());
        if (delivery.getAddress() != null) deliveryForUpdate.setAddress(delivery.getAddress());
        if (delivery.getPhoneNumber() != null) deliveryForUpdate.setPhoneNumber(delivery.getPhoneNumber());
        if (delivery.getPriceOfDelivery() != null) deliveryForUpdate.setPriceOfDelivery(delivery.getPriceOfDelivery());
        if (delivery.getOrder() != null) deliveryForUpdate.setOrder(delivery.getOrder());

        return deliveryRepository.save(deliveryForUpdate);
    }

    @Override
    public Delivery deleteById(Long id) {
        Delivery deliveryForDelete = getById(id);
        if (deliveryForDelete != null) deliveryRepository.delete(deliveryForDelete);

        return deliveryForDelete;
    }
}
