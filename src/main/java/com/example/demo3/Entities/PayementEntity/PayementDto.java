package com.example.demo3.Entities.PayementEntity;

import com.example.demo3.Entities.ReservationEntity.ReservationDto;
import com.example.demo3.Entities.ReservationEntity.ReservationEntity;
import com.example.demo3.Entities.UserEntity.UserDto;
import com.example.demo3.Entities.UserEntity.UserEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Data
public class PayementDto {
    private long id;
    private String methodepayement;
    private long amount; // Utilisez le nom en minuscules pour suivre les conventions Java
    private UserDto user; // Utilisez un DTO pour l'utilisateur associé
    private ReservationDto reservation; // Utilisez un DTO pour la réservation associée
}
