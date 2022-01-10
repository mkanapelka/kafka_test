package com.example.shop_kafka_mongo.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Builder
@Getter
@Setter
public class ProductDto implements Serializable {

    private String name;
    private String description;
    private byte[] image;
}
