package com.example.shop_consumer_kafka_mongo.configuration;

import com.example.shop_consumer_kafka_mongo.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.mapping.DefaultJackson2JavaTypeMapper;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
@RequiredArgsConstructor
public class KafkaConsumerConfig {
    private static final String PRODUCT_PATH = "com.example.shop_consumer_kafka_mongo.dto.ProductDto";
    private static final String ALL_PACKAGES_TRUSTED_VALUE = "*";
    private static final String NAME_GROUP_ID_CONFIG = "consuming";

    private final KafkaProperties kafkaProperties;

    @Bean
    public ConsumerFactory<String, ProductDto> consumerFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getKafkaServer());
        config.put(ConsumerConfig.GROUP_ID_CONFIG, NAME_GROUP_ID_CONFIG);
        JsonDeserializer<ProductDto> jsonDeserializer = getProductDeserializer();

        return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(), jsonDeserializer);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, ProductDto> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, ProductDto> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());

        return factory;
    }

    private JsonDeserializer<ProductDto> getProductDeserializer() {
        DefaultJackson2JavaTypeMapper typeMapper = new DefaultJackson2JavaTypeMapper();
        Map<String, Class<?>> classMap = new HashMap<>();
        classMap.put(PRODUCT_PATH, ProductDto.class);
        typeMapper.setIdClassMapping(classMap);
        typeMapper.addTrustedPackages(ALL_PACKAGES_TRUSTED_VALUE);

        JsonDeserializer<ProductDto> jsonDeserializer = new JsonDeserializer<>(ProductDto.class);
        jsonDeserializer.setTypeMapper(typeMapper);
        jsonDeserializer.setUseTypeMapperForKey(true);

        return jsonDeserializer;
    }
}
