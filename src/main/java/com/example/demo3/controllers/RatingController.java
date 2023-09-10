package com.example.demo3.controllers;

import com.example.demo3.Converter.RatingConverter;
import com.example.demo3.Entities.LogementEntity.LogementEntity;
import com.example.demo3.Entities.RatingEntity.RatingDto;
import com.example.demo3.Entities.RatingEntity.RatingEntity;
import com.example.demo3.Entities.UserEntity.UserEntity;
import com.example.demo3.Exceptions.RatingException;
import com.example.demo3.Service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    private final RatingService ratingService;
    private final RatingConverter ratingConverter; // Injectez RatingConverter

    @Autowired
    public RatingController(RatingService ratingService, RatingConverter ratingConverter) {
        this.ratingService = ratingService;
        this.ratingConverter = ratingConverter;
    }

    @GetMapping("/byLogement")
    public ResponseEntity<?> getRatingsByLogement(@RequestBody LogementEntity logement) {

        try {
            List<RatingEntity> ratings = ratingService.findAllByLogement(logement);

            // Utilisez RatingConverter pour convertir les entités en DTOs
            List<RatingDto> ratingDtos = ratings.stream()
                    .map(ratingConverter::entityToDTO)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(ratingDtos);
        } catch (RatingException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la récupération des évaluations.");
        }
    }


    @GetMapping("/byUser")
    public ResponseEntity<?> getRatingsByUser(@RequestParam long userId) {
        UserEntity user = new UserEntity(); // Vous devrez obtenir l'utilisateur à partir de votre service d'utilisateur
        try {
            List<RatingEntity> ratings = ratingService.findAllByUser(user);

            // Utilisez RatingConverter pour convertir les entités en DTOs
            List<RatingDto> ratingDtos = ratings.stream()
                    .map(ratingConverter::entityToDTO)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(ratingDtos);
        } catch (RatingException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la récupération des évaluations.");
        }
    }



    @PostMapping("/save")
    public ResponseEntity<?> saveRating(@RequestBody RatingEntity rating) {
        try {

            RatingEntity savedRating = ratingService.save(rating);


            RatingDto ratingDto = ratingConverter.entityToDTO(savedRating);

            return ResponseEntity.status(HttpStatus.CREATED).body(ratingDto);
        } catch (Exception ex) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erreur de validation de l'évaluation : " + ex.getMessage());
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getRatingById(@PathVariable Long id) {
        try {
            Optional<RatingEntity> ratingOptional = ratingService.findById(id);
            if (ratingOptional.isPresent()) {
                RatingEntity rating = ratingOptional.get();


                RatingDto ratingDto = ratingConverter.entityToDTO(rating);

                return ResponseEntity.ok(ratingDto);
            } else {
                throw new RatingException("Évaluation non trouvée avec l'ID : " + id);
            }
        } catch (RatingException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

@DeleteMapping("/{id}")
    public void deleteRatingById(@PathVariable Long id) {
        ratingService.deleteById(id);
    } }




