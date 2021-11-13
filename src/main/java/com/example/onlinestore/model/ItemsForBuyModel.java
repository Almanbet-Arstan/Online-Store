package com.example.onlinestore.model;

import com.example.onlinestore.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemsForBuyModel {
    List<Product> productList;
    Long userId;
}
