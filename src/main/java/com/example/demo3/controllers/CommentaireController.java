package com.example.demo3.controllers;

import com.example.demo3.Entities.CommentaireEntity.CommentaireEntity;
import com.example.demo3.Entities.ReservationEntity.ReservationEntity;
import com.example.demo3.Entities.UserEntity.UserEntity;
import com.example.demo3.Service.CommentaireService;
import com.example.demo3.Service.CommentaireServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commentaires")
public class CommentaireController {

    private final CommentaireService commentaireService;

    @Autowired
    public CommentaireController(CommentaireService commentaireService) {
        this.commentaireService = commentaireService;
    }

    @GetMapping("/all")
    public List<CommentaireEntity> getAllCommentaires() {
        return commentaireService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteCommentaireById(@PathVariable long id) {
        commentaireService.deleteById(id);
    }

    @GetMapping("/byReservation")
    public List<CommentaireEntity> getCommentairesByReservation(@RequestParam long reservationId) {
        ReservationEntity reservation = new ReservationEntity(); // Vous devrez obtenir la réservation à partir de votre service de réservation
        return commentaireService.findAllByReservation(reservation);
    }

    @GetMapping("/byUser")
    public List<CommentaireEntity> getCommentairesByUser(@RequestParam long userId) {
        UserEntity user = new UserEntity(); // Vous devrez obtenir l'utilisateur à partir de votre service d'utilisateur
        return commentaireService.findAllByUser(user);
    }
    @PostMapping("/create")
    public CommentaireEntity createCommentaire(@RequestBody CommentaireEntity commentaire) {
        return commentaireService.save(commentaire);
    }

    // Endpoint pour récupérer un commentaire par son ID
    @GetMapping("/{id}")
    public CommentaireEntity getCommentaireById(@PathVariable long id) {
        // Vous devrez obtenir le commentaire à partir de votre service de commentaires
        return commentaireService.findById(id).orElse(null);
    }

    // Endpoint pour mettre à jour un commentaire par son ID
    @PutMapping("/{id}")
    public CommentaireEntity updateCommentaire(@PathVariable long id, @RequestBody CommentaireEntity updatedCommentaire) {
        commentaireService.save(updatedCommentaire);
        return updatedCommentaire;
    }
}

