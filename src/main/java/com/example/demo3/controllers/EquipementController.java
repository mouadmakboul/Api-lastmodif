package com.example.demo3.controllers;

import com.example.demo3.Entities.EquipementEntity.EquipementEntity;
import com.example.demo3.Service.EquipementService;
import com.example.demo3.Service.EquipementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/equipements")
public class EquipementController {

    private final EquipementService equipementService;

    @Autowired
    public EquipementController(EquipementService equipementService) {
        this.equipementService = equipementService;
    }

    @GetMapping("/byName")
    public EquipementEntity getEquipementByName(@RequestParam String nameEquipement) {
        return equipementService.findByNameEquipement(nameEquipement);
    }

    @GetMapping("/existsByName")
    public boolean doesEquipementExistByName(@RequestParam String nameEquipement) {
        return equipementService.existsByNameEquipement(nameEquipement);
    }
}
