package com.example.demo3.controllers;

import com.example.demo3.Entities.LogementEntity.LogementEntity;
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

@RestController
@RequestMapping("/ratings")
public class RatingController {

    private final RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping("/byLogement")
    public List<RatingEntity> getRatingsByLogement(@RequestParam long logementId) {
        LogementEntity logement = new LogementEntity(); // Vous devrez obtenir le logement à partir de votre service de logement
        return ratingService.findAllByLogement(logement);
    }


    @GetMapping("/byUser")
    public List<RatingEntity> getRatingsByUser(@RequestParam long userId) {
        UserEntity user = new UserEntity(); // Vous devrez obtenir l'utilisateur à partir de votre service d'utilisateur
        return ratingService.findAllByUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteRatingById(@PathVariable Long id) {
        ratingService.deleteById(id);
    }
    @PostMapping("/save")
    public ResponseEntity<?> saveRating(@RequestBody RatingEntity rating) {
        try {
            // Effectuez ici des validations d'évaluation, si nécessaire
            RatingEntity savedRating = ratingService.save(rating);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedRating);
        } catch (Exception ex) {
            // Gérez les erreurs de validation ici
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erreur de validation de l'évaluation : " + ex.getMessage());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getRatingById(@PathVariable Long id) {
        try {
            Optional<RatingEntity> rating = ratingService.findById(id);
            if (rating.isPresent()) {
                return ResponseEntity.ok(rating.get());
            } else {
                throw new RatingException("Évaluation non trouvée avec l'ID : " + id);
            }
        } catch (RatingException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

}
