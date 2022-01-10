package com.example.shop_kafka_mongo.service;

import com.example.shop_kafka_mongo.controller.dto.ProductDto;

public interface ProductService {

    ProductDto createProduct(ProductDto productDto);
}
