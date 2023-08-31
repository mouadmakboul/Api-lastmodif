package com.example.demo3.Service;

import com.example.demo3.Entities.CategoryEntity.CategoryEntity;
import com.example.demo3.Entities.LogementEntity.LogementEntity;

import java.util.List;

public interface CategoryService {
    CategoryEntity findByName(String name);
    List<CategoryEntity> findAllByLogementsContains(LogementEntity logement);
    boolean existsByName(String name);
}

