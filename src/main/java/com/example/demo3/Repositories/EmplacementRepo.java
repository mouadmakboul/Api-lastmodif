package com.example.demo3.Repositories;

import com.example.demo3.Entities.EmplacementEntity.EmplacementEntity;
import com.example.demo3.Entities.LogementEntity.LogementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmplacementRepo extends JpaRepository<EmplacementEntity,Long> {
    EmplacementEntity findByZonegeo(String zonegeo);
    List<LogementEntity> findLogementsByZonegeo(String zonegeo);
    boolean existsById(Long id);
    Long countByZonegeo(String zonegeo);



}
