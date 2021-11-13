package com.example.onlinestore.converter;

import com.example.onlinestore.entity.*;
import com.example.onlinestore.model.DeliveryModel;
import com.example.onlinestore.model.UserProductModel;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class DeliveryConverter extends BaseConverter<DeliveryModel, Delivery>{
    public DeliveryConverter() {
        super(DeliveryConverter::convertToEntity, DeliveryConverter::convertToModel);
    }

    private static DeliveryModel convertToModel(Delivery entityToConvert){
        if (entityToConvert == null) return null;
        return DeliveryModel.builder()
                .address(entityToConvert.getAddress())
                .phoneNumber(entityToConvert.getPhoneNumber())
                .priceOfDelivery(entityToConvert.getPriceOfDelivery())
                .orderId(entityToConvert.getOrder().getId())
                .build();
    }

    private static Delivery convertToEntity(DeliveryModel modelToConvert){
        if (modelToConvert == null) return null;

        Delivery deliveryToReturn = new Delivery();

        deliveryToReturn.setAddress(modelToConvert.getAddress());
        deliveryToReturn.setPhoneNumber(modelToConvert.getPhoneNumber());
        deliveryToReturn.setPriceOfDelivery(modelToConvert.getPriceOfDelivery());
        Order order = new Order();
        order.setId(modelToConvert.getOrderId());
        deliveryToReturn.setOrder(order);

        return deliveryToReturn;
    }
}
