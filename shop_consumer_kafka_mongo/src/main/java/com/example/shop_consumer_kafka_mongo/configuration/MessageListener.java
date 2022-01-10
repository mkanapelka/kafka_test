package com.example.shop_consumer_kafka_mongo.configuration;

import com.example.shop_consumer_kafka_mongo.dto.ProductDto;
import com.example.shop_consumer_kafka_mongo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageListener {

    private final ProductService productService;

    @KafkaListener(groupId = "localTest", topics = {"${kafka-settings.topic-name}"}, containerFactory = "kafkaListenerContainerFactory")
    public void listener(ProductDto product) {
        System.out.println("Recieved message: " + product);
        productService.saveMessage(product);
    }
}
