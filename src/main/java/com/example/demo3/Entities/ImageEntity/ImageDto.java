package com.example.demo3.Entities.ImageEntity;

import com.example.demo3.Entities.LogementEntity.LogementDto;
import com.example.demo3.Entities.UserEntity.UserDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Data
public class ImageDto {
    private long id;
    private String path;
    private String name;
    private String type;
    private LogementDto logement; // Utilisez un DTO pour le logement associé, par exemple, LogementDto
    private UserDto user; // Utilisez un DTO pour l'utilisateur associé, par exemple, UserDto
}
