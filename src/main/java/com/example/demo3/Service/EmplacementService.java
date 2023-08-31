package com.example.demo3.Service;

import com.example.demo3.Entities.EmplacementEntity.EmplacementEntity;
import com.example.demo3.Entities.LogementEntity.LogementEntity;

import java.util.List;

public interface EmplacementService {
    EmplacementEntity findByZonegeo(String zonegeo);
    List<LogementEntity> findLogementsByZonegeo(String zonegeo);
    boolean existsById(Long id);
    Long countByZonegeo(String zonegeo);
}

