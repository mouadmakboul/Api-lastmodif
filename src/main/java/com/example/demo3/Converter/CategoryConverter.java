package com.example.demo3.Converter;

import com.example.demo3.Entities.CategoryEntity.CategoryDto;
import com.example.demo3.Entities.CategoryEntity.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter {

    public CategoryDto entityToDTO(CategoryEntity categoryEntity) {
        return new CategoryDto() {{
            setId(categoryEntity.getId());
            setName(categoryEntity.getName());
            setImage(categoryEntity.getImage());
            // Ajoutez d'autres propriétés de l'entité CategoryEntity ici
        }};
    }
}

