package com.example.demo3.Entities.CategoryEntity;

import com.example.demo3.Entities.LogementEntity.LogementDto;
import lombok.Data;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter

@Data
public class CategoryDto {
    private long id;
    private String name;
    private String image;
    private List<LogementDto> logements; // Utilisez un DTO pour les logements associés, par exemple, LogementDto
}
