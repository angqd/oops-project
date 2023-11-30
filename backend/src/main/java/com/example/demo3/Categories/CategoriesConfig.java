package com.example.demo3.Categories;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CategoriesConfig {
    @Bean(name = "CategoryRunner")
    CommandLineRunner commandLineRunner(CategoriesRepo categoriesRepo){
        return args -> {
            Categories cat = new Categories("Tech and appliances");
            Categories cat2 = new Categories("Clothing");
            Categories cat3 = new Categories("Books and Stationary");
            Categories cat4 = new Categories("Room items ");
            Categories cat5 = new Categories("Misc");
            categoriesRepo.saveAll(List.of(cat,cat2,cat3,cat4,cat5));
        };
    }
}
