package com.example.demo3.Service;

import com.example.demo3.Entities.LogementEntity.LogementEntity;
import com.example.demo3.Entities.UserEntity.UserEntity;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface LogementService {
    LogementEntity findByTitle(String title);
    Optional<LogementEntity> findById(Long id);
    List<LogementEntity> findAllByUser(UserEntity user);
    List<LogementEntity> findAllAvailableBetweenDates(Date startDate, Date endDate);

    // Supprimer un logement par son ID
    void deleteById(Long id);

    // Mettre à jour les informations d'un logement
    LogementEntity update(LogementEntity logement);

    LogementEntity save(LogementEntity logement);
}
