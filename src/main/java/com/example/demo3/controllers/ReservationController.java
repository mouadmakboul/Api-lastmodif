package com.example.demo3.controllers;

import com.example.demo3.Entities.LogementEntity.LogementEntity;
import com.example.demo3.Entities.ReservationEntity.ReservationEntity;
import com.example.demo3.Entities.UserEntity.UserEntity;
import com.example.demo3.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/byLogement")
    public List<ReservationEntity> getReservationsByLogement(@RequestParam long logementId) {
        LogementEntity logement = new LogementEntity(); // Vous devrez obtenir le logement à partir de votre service de logement
        return reservationService.findAllByLogement(logement);
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
    public ReservationEntity saveReservation(@RequestBody ReservationEntity reservation) {
        // Utilisez votre service pour enregistrer la réservation
        return reservationService.save(reservation);
    }

    @DeleteMapping("/{id}")
    public void deleteReservationById(@PathVariable Long id) {
        // Utilisez votre service pour supprimer la réservation par ID
        reservationService.deleteById(id);
    }
    @GetMapping("/byStartDateBetween")
    public List<ReservationEntity> getReservationsByStartDateBetween(
            @RequestParam(name = "startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
            @RequestParam(name = "endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {
        return reservationService.findAllByStartDateBetween(startDate, endDate);
    }

}
