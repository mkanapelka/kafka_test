package com.example.shop_kafka_mongo.service;

import com.example.shop_kafka_mongo.controller.dto.ProductDto;
import com.example.shop_kafka_mongo.producer.ProductProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductProducer producer;

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        producer.sendMessage(productDto);
        return productDto;
    }
}
