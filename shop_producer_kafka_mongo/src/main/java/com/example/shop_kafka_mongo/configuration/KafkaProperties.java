package com.example.shop_kafka_mongo.configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(value = "kafka-settings")
@Getter
@Setter
@ToString
public class KafkaProperties {
    private String kafkaServer;
    private String topicName;
    private Integer quantityPartitions;
    private Integer quantityReplicas;
}
