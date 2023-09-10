package com.example.demo3.controllers;

import com.example.demo3.Converter.ReservationConverter;
import com.example.demo3.Entities.LogementEntity.LogementEntity;
import com.example.demo3.Entities.ReservationEntity.ReservationDto;
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
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;
    private final ReservationConverter reservationConverter; // Injectez ReservationConverter

    @Autowired
    public ReservationController(ReservationService reservationService, ReservationConverter reservationConverter) {
        this.reservationService = reservationService;
        this.reservationConverter = reservationConverter;
    }
    @Autowired
    LogementService logementService;

    @GetMapping("/byLogement")
    public ResponseEntity<?> getReservationsByLogement(@RequestParam long logementId) {
        try {
            Optional<LogementEntity> logement = logementService.findById(logementId); // Obtenez le logement à partir de votre service de logement
            if (logement.isPresent()) {
                List<ReservationEntity> reservations = reservationService.findAllByLogement(Optional.of(logement.get()));

                // Utilisez ReservationConverter pour convertir les entités en DTOs
                List<ReservationDto> reservationDtos = reservations.stream()
                        .map(reservationConverter::entityToDTO)
                        .collect(Collectors.toList());

                return ResponseEntity.ok(reservationDtos);
            } else {
                throw new ReservationException("Logement not found with ID: " + logementId);
            }
        } catch (ReservationException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }


    @GetMapping("/byUserAndLogement")
    public ResponseEntity<?> getReservationsByUserAndLogement(
            @RequestBody UserEntity user,
            @RequestBody LogementEntity logement) {

        try {
            List<ReservationEntity> reservations = reservationService.findAllByUserAndLogement(user, logement);


            List<ReservationDto> reservationDtos = reservations.stream()
                    .map(reservationConverter::entityToDTO)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(reservationDtos);
        } catch (ReservationException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
    @PostMapping("/save")
    public ResponseEntity<?> saveReservation(@RequestBody ReservationEntity reservation) {
        try {
            if (!reservationService.isReservationValid(reservation)) {
                throw new ReservationException("La date de réservation est invalide.");
            }
            ReservationEntity createdReservation = reservationService.save(reservation);


            ReservationDto reservationDto = reservationConverter.entityToDTO(createdReservation);

            return ResponseEntity.status(HttpStatus.CREATED).body(reservationDto);
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
    public List<ReservationDto> getReservationsByStartDateBetween(
            @RequestParam(name = "startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
            @RequestParam(name = "endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {
        List<ReservationEntity> reservations = reservationService.findAllByStartDateBetween(startDate, endDate);


        List<ReservationDto> reservationDtos = reservations.stream()
                .map(reservationConverter::entityToDTO)
                .collect(Collectors.toList());

        return reservationDtos;
    }
}
