package com.example.demo3.controllers;

import com.example.demo3.Entities.LogementEntity.LogementEntity;
import com.example.demo3.Entities.RatingEntity.RatingEntity;
import com.example.demo3.Entities.UserEntity.UserEntity;
import com.example.demo3.Service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public RatingEntity saveRating(@RequestBody RatingEntity rating) {
        // Utilisez votre service pour enregistrer l'évaluation
        return ratingService.save(rating);
    }
}
