package com.example.demo3.Entities.PayementEntity;

import com.example.demo3.Entities.ReservationEntity.ReservationEntity;
import com.example.demo3.Entities.UserEntity.UserEntity;
import lombok.Data;

@Data
public class PayementDto {
    private String methodepayement;
    private UserEntity user;
    private ReservationEntity reservation;
}
