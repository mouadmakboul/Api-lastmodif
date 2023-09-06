package com.example.demo3.controllers;

import com.example.demo3.Entities.LogementEntity.LogementEntity;
import com.example.demo3.Entities.ReservationEntity.ReservationEntity;
import com.example.demo3.Entities.UserEntity.UserEntity;
import com.example.demo3.Exceptions.ReservationException;
import com.example.demo3.Service.LogementService;
import com.example.demo3.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
    @Autowired
    LogementService logementService;

    @GetMapping("/byLogement")
    public List<ReservationEntity> getReservationsByLogement(@RequestParam long logementId) {
        try {
            Optional<LogementEntity> logement = logementService.findById(logementId); // Obtenez le logement à partir de votre service de logement
            if (logement != null) {
                return reservationService.findAllByLogement(logement);
            } else {
                throw new ReservationException("Logement not found with ID: " + logementId);
            }
        } catch (ReservationException ex) {
            return (List<ReservationEntity>) ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @GetMapping("/byUserAndLogement")
    public List<ReservationEntity> getReservationsByUserAndLogement(
            @RequestParam long userId,
            @RequestParam long logementId) {
        UserEntity user = new UserEntity(); // Vous devrez obtenir l'utilisateur à partir de votre service d'utilisateur
        LogementEntity logement = new LogementEntity(); // Vous devrez obtenir le logement à partir de votre service de logement
        return reservationService.findAllByUserAndLogement(user, logement);
    }
    @PostMapping("/save")
    public ResponseEntity<?> saveReservation(@RequestBody ReservationEntity reservation) {
        try {
            if (!reservationService.isReservationValid(reservation)) {
                throw new ReservationException("La date de réservation est invalide.");
            }
            ReservationEntity createdReservation = reservationService.save(reservation);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdReservation);
        } catch (ReservationException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReservationById(@PathVariable Long id) {
        try {
            reservationService.deleteById(id);
            return ResponseEntity.ok("La réservation avec l'ID " + id + " a été supprimée avec succès.");
        } catch (ReservationException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Une erreur s'est produite lors de la suppression de la réservation.");
        }
    }

    @GetMapping("/byStartDateBetween")
    public List<ReservationEntity> getReservationsByStartDateBetween(
            @RequestParam(name = "startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
            @RequestParam(name = "endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {
        return reservationService.findAllByStartDateBetween(startDate, endDate);
    }

}
