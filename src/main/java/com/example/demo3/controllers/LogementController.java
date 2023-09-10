package com.example.demo3.controllers;

import com.example.demo3.Converter.LogementConverter;
import com.example.demo3.Entities.LogementEntity.LogementDto;
import com.example.demo3.Entities.LogementEntity.LogementEntity;
import com.example.demo3.Entities.UserEntity.UserEntity;
import com.example.demo3.Exceptions.LogementException;
import com.example.demo3.Service.LogementService;
import com.example.demo3.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/logements")
public class LogementController {

    private final LogementService logementService;
    @Autowired
    UserService ur;
    private final LogementConverter logementConverter; // Injectez LogementConverter

    @Autowired
    public LogementController(LogementService logementService, LogementConverter logementConverter) {
        this.logementService = logementService;
        this.logementConverter = logementConverter;
    }

    @GetMapping("/byTitle")
    public ResponseEntity<?> getLogementByTitle(@RequestParam String title) {
        try {
            LogementEntity logement = logementService.findByTitle(title);

            // Utilisez LogementConverter pour convertir l'entité en DTO
            LogementDto logementDto = logementConverter.entityToDTO(logement);

            return ResponseEntity.ok(logementDto);
        } catch (LogementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @GetMapping("/byId")
    public ResponseEntity<?> getLogementById(@RequestParam Long id) {
        try {
            Optional<LogementEntity> logementOptional = logementService.findById(id);
            if (logementOptional.isPresent()) {
                LogementEntity logement = logementOptional.get();

                // Utilisez LogementConverter pour convertir l'entité en DTO
                LogementDto logementDto = logementConverter.entityToDTO(logement);

                return ResponseEntity.ok(logementDto);
            } else {
                throw new LogementException("Logement not found with ID: " + id);
            }
        } catch (LogementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }


    @GetMapping("/byUser")
    public ResponseEntity<?> getLogementsByUser(@RequestParam long userId) {
        UserEntity user = ur.findById(userId);
        try {
            List<LogementEntity> logements = logementService.findAllByUser(user);
            return ResponseEntity.ok(logements);
        } catch (LogementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @GetMapping("/availableBetweenDates")
    public List<LogementEntity> getAvailableLogementsBetweenDates(
            @RequestParam(name = "startDate") Date startDate,
            @RequestParam(name = "endDate") Date endDate) {
        return logementService.findAllAvailableBetweenDates(startDate, endDate);
    }
    @PostMapping
    public ResponseEntity<?> createLogement(@RequestBody LogementEntity logement) {
        try {
            LogementEntity createdLogement = logementService.save(logement);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdLogement);
        } catch (LogementException ex) {
            throw new LogementException("Aucun logement n'a été trouvée pour ce logement.");
        }
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
