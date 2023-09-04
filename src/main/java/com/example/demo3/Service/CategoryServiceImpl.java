
package com.example.demo3.Service;
import com.example.demo3.Entities.CategoryEntity.CategoryEntity;

import com.example.demo3.Entities.LogementEntity.LogementEntity;
import com.example.demo3.Exceptions.CategoryException;
import com.example.demo3.Repositories.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepo categoryRepo;

    @Autowired
    public CategoryServiceImpl(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public CategoryEntity findByName(String name) {
        CategoryEntity category = categoryRepo.findByName(name);
        if (category == null) {
            throw new CategoryException("La catégorie spécifiée n'a pas été trouvée.");
        }
        return category;
    }


    @Override
    public List<CategoryEntity> findAllByLogementsContains(LogementEntity logement) {
        return categoryRepo.findAllByLogementsContains(logement);
    }

    @Override
    public boolean existsByName(String name) {
        return categoryRepo.existsByName(name);
    }
}
