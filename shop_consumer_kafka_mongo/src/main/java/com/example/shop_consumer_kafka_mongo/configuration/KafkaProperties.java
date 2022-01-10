package com.example.shop_consumer_kafka_mongo.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(value = "kafka-settings")
@Getter
@Setter
public class KafkaProperties {
    private String kafkaServer;
    private String topicName;
}
