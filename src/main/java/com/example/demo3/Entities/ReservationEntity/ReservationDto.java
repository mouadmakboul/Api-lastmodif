package com.example.demo3.Entities.ReservationEntity;

import com.example.demo3.Entities.LogementEntity.LogementDto;
import com.example.demo3.Entities.PayementEntity.PayementDto;
import com.example.demo3.Entities.UserEntity.UserDto;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Data


@Getter
@Setter
@NoArgsConstructor

public class ReservationDto {
    private long id;
    private Date Datereservation;
    private Date startDate;
    private Date endDate;
    private LogementDto logement; // Utilisez un DTO pour le logement associé
    private UserDto user; // Utilisez un DTO pour l'utilisateur associé
    private PayementDto payement; // Utilisez un DTO pour le paiement associé, si nécessaire
    // Autres propriétés et DTO associés, le cas échéant
}
