package com.example.demo3.Entities.CommentaireEntity;

import com.example.demo3.Entities.ReservationEntity.ReservationDto;
import com.example.demo3.Entities.UserEntity.UserDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@Data
public class CommentaireDto {
    private long id;
    private String text;
    private Date sendDate;
    private boolean way;
    private boolean seen;
    private UserDto user; // Utilisez un DTO pour l'utilisateur associé, par exemple, UserDto
    private ReservationDto reservation; // Utilisez un DTO pour la réservation associée, par exemple, ReservationDto
}
