package com.example.demo3.controllers;

import com.example.demo3.Entities.CategoryEntity.CategoryEntity;
import com.example.demo3.Entities.LogementEntity.LogementEntity;
import com.example.demo3.Exceptions.CategoryException;
import com.example.demo3.Service.CategoryService;
import com.example.demo3.Service.CategoryServiceImpl;
import com.example.demo3.Service.LogementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @Autowired
    private LogementService logementservice;

    @GetMapping("/byName")
    public ResponseEntity<?> getCategoryByName(@RequestParam String name) {
        CategoryEntity category = categoryService.findByName(name);
        if (category == null) {
            throw new CategoryException("Aucune catégorie n'a été trouvée avec le nom spécifié : " + name);
        }
        return ResponseEntity.ok(category);
    }

    @GetMapping("/byLogement")
    public ResponseEntity<?> getCategoriesByLogement(@RequestParam long logementId) {
        Optional<LogementEntity> logement = logementservice.findById(logementId); // Supposons que vous ayez un service LogementService pour obtenir le logement
        List<CategoryEntity> categories = categoryService.findAllByLogementsContains(logement);
        if (categories.isEmpty()) {
            throw new CategoryException("Aucune catégorie n'a été trouvée pour ce logement.");
        }
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/existsByName")
    public ResponseEntity<?> doesCategoryExistByName(@RequestParam String name) {
        boolean exists = categoryService.existsByName(name);
        if (!exists) {
            throw new CategoryException("Aucune catégorie n'a été trouvée avec le nom spécifié : " + name);
        }
        return ResponseEntity.ok(exists);
    }}
