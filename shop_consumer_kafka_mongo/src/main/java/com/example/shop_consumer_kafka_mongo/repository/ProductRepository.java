package com.example.shop_consumer_kafka_mongo.repository;

import com.example.shop_consumer_kafka_mongo.dto.ProductDto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<ProductDto, String> {
}
