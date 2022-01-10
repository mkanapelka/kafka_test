package com.example.shop_consumer_kafka_mongo.service;

import com.example.shop_consumer_kafka_mongo.dto.ProductDto;

public interface ProductService {
    ProductDto saveMessage(ProductDto product);
}
