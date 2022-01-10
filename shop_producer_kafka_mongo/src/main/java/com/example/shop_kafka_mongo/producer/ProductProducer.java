package com.example.shop_kafka_mongo.producer;

import com.example.shop_kafka_mongo.configuration.KafkaProperties;
import com.example.shop_kafka_mongo.controller.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProductProducer {

    private final KafkaTemplate<String, ProductDto> kafkaTemplate;
    private final KafkaProperties kafkaProperties;

    public void sendMessage(ProductDto productDto) {
        ListenableFuture<SendResult<String, ProductDto>> future = kafkaTemplate.send(kafkaProperties.getTopicName(), productDto);

        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onFailure(Throwable throwable) {
                log.error("Unable to send message = {} dut to: {}", productDto, throwable.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, ProductDto> stringDataSendResult) {
                log.info("Sent Message = {} with offset = {}", productDto, stringDataSendResult.getRecordMetadata().offset());
            }
        });
    }
}
