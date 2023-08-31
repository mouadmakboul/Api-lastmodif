package com.example.demo3.controllers;

import com.example.demo3.Entities.EmplacementEntity.EmplacementEntity;
import com.example.demo3.Entities.LogementEntity.LogementEntity;
import com.example.demo3.Service.EmplacementService;
import com.example.demo3.Service.EmplacementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emplacements")
public class EmplacementController {

    private final EmplacementService emplacementService;

    @Autowired
    public EmplacementController(EmplacementService emplacementService) {
        this.emplacementService = emplacementService;
    }

    @GetMapping("/byZonegeo")
    public EmplacementEntity getEmplacementByZonegeo(@RequestParam String zonegeo) {
        return emplacementService.findByZonegeo(zonegeo);
    }

    @GetMapping("/logementsByZonegeo")
    public List<LogementEntity> getLogementsByZonegeo(@RequestParam String zonegeo) {
        return emplacementService.findLogementsByZonegeo(zonegeo);
    }

    @GetMapping("/existsById")
    public boolean doesEmplacementExistById(@RequestParam Long id) {
        return emplacementService.existsById(id);
    }

    @GetMapping("/countByZonegeo")
    public Long countEmplacementsByZonegeo(@RequestParam String zonegeo) {
        return emplacementService.countByZonegeo(zonegeo);
    }
}
