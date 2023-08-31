package com.example.demo3.controllers;

import com.example.demo3.Entities.CategoryEntity.CategoryEntity;
import com.example.demo3.Entities.LogementEntity.LogementEntity;
import com.example.demo3.Service.CategoryService;
import com.example.demo3.Service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/byName")
    public CategoryEntity getCategoryByName(@RequestParam String name) {
        return categoryService.findByName(name);
    }

    @GetMapping("/byLogement")
    public List<CategoryEntity> getCategoriesByLogement(@RequestParam long logementId) {
        LogementEntity logement = new LogementEntity(); // Vous devrez obtenir le logement à partir de votre service de logement
        return categoryService.findAllByLogementsContains(logement);
    }

    @GetMapping("/existsByName")
    public boolean doesCategoryExistByName(@RequestParam String name) {
        return categoryService.existsByName(name);
    }
}
