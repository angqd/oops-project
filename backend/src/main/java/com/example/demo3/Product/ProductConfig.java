package com.example.demo3.Product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
public class ProductConfig implements CommandLineRunner {

    private final ProductRepo productRepository;

    public ProductConfig(ProductRepo productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Initialize and save some product data
        Product bulb = new Product();
        bulb.setName("Light Bulb");
        bulb.setDescription("A bright light source");
        bulb.setCreatedAt(LocalDateTime.now());
        productRepository.save(bulb);
    }
}
