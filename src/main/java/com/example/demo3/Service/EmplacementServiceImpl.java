package com.example.demo3.Service;

import com.example.demo3.Entities.EmplacementEntity.EmplacementEntity;
import com.example.demo3.Entities.LogementEntity.LogementEntity;
import com.example.demo3.Repositories.EmplacementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmplacementServiceImpl implements EmplacementService {
    private final EmplacementRepo emplacementRepo;

    @Autowired
    public EmplacementServiceImpl(EmplacementRepo emplacementRepo) {
        this.emplacementRepo = emplacementRepo;
    }

    @Override
    public EmplacementEntity findByZonegeo(String zonegeo) {
        return emplacementRepo.findByZonegeo(zonegeo);
    }

    @Override
    public List<LogementEntity> findLogementsByZonegeo(String zonegeo) {
        return emplacementRepo.findLogementsByZonegeo(zonegeo);
    }

    @Override
    public boolean existsById(Long id) {
        return emplacementRepo.existsById(id);
    }

    @Override
    public Long countByZonegeo(String zonegeo) {
        return emplacementRepo.countByZonegeo(zonegeo);
    }
}

