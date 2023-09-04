package com.example.demo3.Entities.RatingEntity;
import com.example.demo3.Entities.LogementEntity.LogementDto;
import com.example.demo3.Entities.LogementEntity.LogementEntity;
import com.example.demo3.Entities.UserEntity.UserDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class RatingDto {
    private long id;
    private String rating;
    private int ratingvalue;
    private LogementDto logement; // Utilisez un DTO pour le logement associé
    private UserDto user; // Utilisez un DTO pour l'utilisateur associé
}
