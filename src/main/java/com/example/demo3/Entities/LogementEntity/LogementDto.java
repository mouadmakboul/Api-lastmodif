package com.example.demo3.Entities.LogementEntity;

import com.example.demo3.Entities.CategoryEntity.CategoryDto;
import com.example.demo3.Entities.EmplacementEntity.EmplacementDto;
import com.example.demo3.Entities.EquipementEntity.EquipementDto;
import com.example.demo3.Entities.ImageEntity.ImageDto;
import com.example.demo3.Entities.RatingEntity.RatingDto;
import com.example.demo3.Entities.ReservationEntity.ReservationDto;
import com.example.demo3.Entities.UserEntity.UserDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter

@Data
public class LogementDto {
    private long id;
    private String title;
    private String description;
    private String adresse;
    private Date startdate;
    private Date enddate;
    private List<ImageDto> images; // Utilisez des DTO pour les images associées
    private RatingDto rating; // Utilisez un DTO pour le rating associé
    private UserDto user; // Utilisez un DTO pour l'utilisateur associé
    private List<ReservationDto> reservations; // Utilisez des DTO pour les réservations associées
    private List<EquipementDto> equipements; // Utilisez des DTO pour les équipements associés
    private EmplacementDto emplacement; // Utilisez un DTO pour l'emplacement associé
    private List<CategoryDto> categories; // Utilisez des DTO pour les catégories associées
}






