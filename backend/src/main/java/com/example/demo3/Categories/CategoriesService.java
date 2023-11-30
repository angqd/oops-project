package com.example.demo3.Categories;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesService {
    private final CategoriesRepo categoriesRepo;

    public CategoriesService(CategoriesRepo categoriesRepo) {
        this.categoriesRepo = categoriesRepo;
    }

    public List<Categories> getAllCategories() {
        return categoriesRepo.findAll();
    }
}
