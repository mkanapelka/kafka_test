package com.example.shop_kafka_mongo.controller;

import com.example.shop_kafka_mongo.controller.dto.ProductDto;
import com.example.shop_kafka_mongo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.shop_kafka_mongo.controller.ProductController.ROOT_URL;


@RestController
@RequestMapping(ROOT_URL)
@RequiredArgsConstructor
public class ProductController {

    public static final String ROOT_URL = "/api/products";

    private final ProductService productService;

    @PostMapping
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        return productService.createProduct(productDto);
    }
}
