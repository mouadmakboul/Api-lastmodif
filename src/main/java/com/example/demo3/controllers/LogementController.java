package com.example.demo3.controllers;

import com.example.demo3.Entities.LogementEntity.LogementEntity;
import com.example.demo3.Entities.UserEntity.UserEntity;
import com.example.demo3.Service.LogementService;
import com.example.demo3.Service.LogementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/logements")
public class LogementController {

    private final LogementService logementService;

    @Autowired
    public LogementController(LogementService logementService) {
        this.logementService = logementService;
    }

    @GetMapping("/byTitle")
    public LogementEntity getLogementByTitle(@RequestParam String title) {
        return logementService.findByTitle(title);
    }

    @GetMapping("/byId")
    public Optional<LogementEntity> getLogementById(@RequestParam Long id) {
        return logementService.findById(id);
    }

    @GetMapping("/byUser")
    public List<LogementEntity> getLogementsByUser(@RequestParam long userId) {
        UserEntity user = new UserEntity(); // Vous devrez obtenir l'utilisateur à partir de votre service d'utilisateur
        return logementService.findAllByUser(user);
    }

    @GetMapping("/availableBetweenDates")
    public List<LogementEntity> getAvailableLogementsBetweenDates(
            @RequestParam(name = "startDate") Date startDate,
            @RequestParam(name = "endDate") Date endDate) {
        return logementService.findAllAvailableBetweenDates(startDate, endDate);
    }
    @PostMapping
    public LogementEntity createLogement(@RequestBody LogementEntity logement) {
        return logementService.save(logement);
    }

    @PutMapping("/{id}")
    public LogementEntity updateLogement(@PathVariable Long id, @RequestBody LogementEntity updatedLogement) {
        logementService.update(updatedLogement);
        return updatedLogement;
    }

    @DeleteMapping("/{id}")
    public void deleteLogement(@PathVariable Long id) {
        logementService.deleteById(id);
    }
}
