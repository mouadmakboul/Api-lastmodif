package com.example.demo3.Service;

import com.example.demo3.Entities.EquipementEntity.EquipementEntity;

public interface EquipementService {
    EquipementEntity findByNameEquipement(String nameEquipement);
    boolean existsByNameEquipement(String nameEquipement);
}

