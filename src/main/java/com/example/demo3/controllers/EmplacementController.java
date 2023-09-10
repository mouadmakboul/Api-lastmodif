package com.example.demo3.controllers;

import com.example.demo3.Converter.EmplacementConverter;
import com.example.demo3.Entities.EmplacementEntity.EmplacementDto;
import com.example.demo3.Entities.EmplacementEntity.EmplacementEntity;
import com.example.demo3.Entities.LogementEntity.LogementEntity;
import com.example.demo3.Service.EmplacementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emplacements")
public class EmplacementController {

    private final EmplacementService emplacementService;
    private final EmplacementConverter emplacementConverter; // Injectez EmplacementConverter

    @Autowired
    public EmplacementController(EmplacementService emplacementService, EmplacementConverter emplacementConverter) {
        this.emplacementService = emplacementService;
        this.emplacementConverter = emplacementConverter;
    }

    @GetMapping("/byZonegeo")
    public EmplacementDto getEmplacementByZonegeo(@RequestParam String zonegeo) {
        EmplacementEntity emplacementEntity = emplacementService.findByZonegeo(zonegeo);


        return emplacementConverter.entityToDTO(emplacementEntity);
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
