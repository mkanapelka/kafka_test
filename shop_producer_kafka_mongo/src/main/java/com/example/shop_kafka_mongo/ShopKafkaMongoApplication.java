package com.example.shop_kafka_mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ShopKafkaMongoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopKafkaMongoApplication.class, args);
    }

}
