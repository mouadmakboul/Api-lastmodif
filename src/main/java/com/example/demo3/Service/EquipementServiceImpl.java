package com.example.demo3.Service;

import com.example.demo3.Entities.EquipementEntity.EquipementEntity;
import com.example.demo3.Repositories.EquipementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipementServiceImpl implements EquipementService {
    private final EquipementRepo equipementRepo;

    @Autowired
    public EquipementServiceImpl(EquipementRepo equipementRepo) {
        this.equipementRepo = equipementRepo;
    }

    @Override
    public EquipementEntity findByNameEquipement(String nameEquipement) {
        return equipementRepo.findByNameEquipement(nameEquipement);
    }

    @Override
    public boolean existsByNameEquipement(String nameEquipement) {
        return equipementRepo.existsByNameEquipement(nameEquipement);
    }
}

