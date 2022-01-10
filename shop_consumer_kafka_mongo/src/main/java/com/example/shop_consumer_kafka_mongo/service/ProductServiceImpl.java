package com.example.shop_consumer_kafka_mongo.service;

import com.example.shop_consumer_kafka_mongo.dto.ProductDto;
import com.example.shop_consumer_kafka_mongo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Override
    public ProductDto saveMessage(ProductDto product) {
        return productRepository.save(product);
    }
}
