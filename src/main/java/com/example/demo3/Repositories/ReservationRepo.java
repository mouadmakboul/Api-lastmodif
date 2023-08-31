package com.example.demo3.Repositories;

import com.example.demo3.Entities.LogementEntity.LogementEntity;
import com.example.demo3.Entities.ReservationEntity.ReservationEntity;
import com.example.demo3.Entities.UserEntity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepo extends JpaRepository<ReservationEntity, Long> {
    List<ReservationEntity> findAllByLogement(LogementEntity logement);
    List<ReservationEntity> findAllByUserAndLogement(UserEntity user, LogementEntity logement);

    // Ajouter une méthode save personnalisée
    ReservationEntity save(ReservationEntity reservation);

    // Ajouter une méthode delete personnalisée en utilisant l'ID
    void deleteById(Long id);
    List<ReservationEntity> findAllByStartDateBetween(Date startDate, Date endDate);

}