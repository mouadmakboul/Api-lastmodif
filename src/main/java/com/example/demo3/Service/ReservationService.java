package com.example.demo3.Service;

import com.example.demo3.Entities.LogementEntity.LogementEntity;
import com.example.demo3.Entities.ReservationEntity.ReservationEntity;
import com.example.demo3.Entities.UserEntity.UserEntity;

import java.util.Date;
import java.util.List;

public interface ReservationService {
    List<ReservationEntity> findAllByLogement(LogementEntity logement);
    List<ReservationEntity> findAllByUserAndLogement(UserEntity user, LogementEntity logement);
    ReservationEntity save(ReservationEntity reservation);

    // Ajouter une méthode delete personnalisée en utilisant l'ID
    void deleteById(Long id);
    List<ReservationEntity> findAllByStartDateBetween(Date startDate, Date endDate);
}

