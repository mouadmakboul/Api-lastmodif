package com.example.demo3.Repositories;

import com.example.demo3.Entities.LogementEntity.LogementEntity;
import com.example.demo3.Entities.UserEntity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface LogementRepo extends JpaRepository<LogementEntity, Long> {
    LogementEntity findByTitle(String title);
    Optional<LogementEntity> findById(Long id);
    List<LogementEntity> findAllByUser(UserEntity user);
    List<LogementEntity> findAllByStartdateBeforeAndEnddateAfter(Date startDate, Date endDate);

    // Ajouter une méthode pour supprimer un logement par son ID
    void deleteById(Long id);

    // Ajouter une méthode pour mettre à jour un logement
    LogementEntity save(LogementEntity logement);
}
