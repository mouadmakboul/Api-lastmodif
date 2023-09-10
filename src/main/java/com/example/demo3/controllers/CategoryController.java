package com.example.demo3.controllers;

import com.example.demo3.Converter.CategoryConverter;
import com.example.demo3.Entities.CategoryEntity.CategoryDto;
import com.example.demo3.Entities.CategoryEntity.CategoryEntity;
import com.example.demo3.Entities.LogementEntity.LogementEntity;
import com.example.demo3.Exceptions.CategoryException;
import com.example.demo3.Service.CategoryService;
import com.example.demo3.Service.LogementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryConverter categoryConverter;

    @Autowired
    public CategoryController(CategoryService categoryService, CategoryConverter categoryConverter) {
        this.categoryService = categoryService;
        this.categoryConverter = categoryConverter;
    }
    @Autowired
    private LogementService logementservice;

    @GetMapping("/byName")
    public ResponseEntity<?> getCategoryByName(@RequestParam String name) {
        CategoryEntity category = categoryService.findByName(name);
        if (category == null) {
            throw new CategoryException("Aucune catégorie n'a été trouvée avec le nom spécifié : " + name);
        }

        // Convertissez l'entité CategoryEntity en DTO CategoryDto en utilisant CategoryConverter
        CategoryDto categoryDto = categoryConverter.entityToDTO(category);

        return ResponseEntity.ok(categoryDto); // Renvoyez le DTO dans la réponse
    }

    @GetMapping("/byLogement")
    public ResponseEntity<?> getCategoriesByLogement(@RequestParam long logementId) {
        Optional<LogementEntity> logement = logementservice.findById(logementId); // Supposons que vous ayez un service LogementService pour obtenir le logement
        List<CategoryEntity> categories = categoryService.findAllByLogementsContains(logement);
        if (categories.isEmpty()) {
            throw new CategoryException("Aucune catégorie n'a été trouvée pour ce logement.");
        }

        // Convertissez la liste d'entités CategoryEntity en une liste de DTO CategoryDto en utilisant CategoryConverter
        List<CategoryDto> categoryDtos = categories.stream()
                .map(categoryConverter::entityToDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(categoryDtos); // Renvoyez la liste de DTOs dans la réponse
    }

    @GetMapping("/existsByName")
    public ResponseEntity<?> doesCategoryExistByName(@RequestParam String name) {
        boolean exists = categoryService.existsByName(name);
        if (!exists) {
            throw new CategoryException("Aucune catégorie n'a été trouvée avec le nom spécifié : " + name);
        }
        return ResponseEntity.ok(exists);
    }
}
