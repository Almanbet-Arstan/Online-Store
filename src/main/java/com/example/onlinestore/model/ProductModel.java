package com.example.onlinestore.model;

import com.example.onlinestore.entity.Image;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductModel {
    private String name;
    private Integer price;
    private Long imageId;
}
