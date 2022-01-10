package com.example.shop_consumer_kafka_mongo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Builder
@Getter
@Setter
@Document
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto implements Serializable {

    @Id
    private ObjectId id;
    private String name;
    private String description;
    private byte[] image;
}
