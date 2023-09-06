package com.example.demo3.controllers;

import com.example.demo3.Entities.CommentaireEntity.CommentaireEntity;
import com.example.demo3.Entities.ReservationEntity.ReservationEntity;
import com.example.demo3.Entities.UserEntity.UserEntity;
import com.example.demo3.Exceptions.CommentaireException;
import com.example.demo3.Service.CommentaireService;
import com.example.demo3.Service.CommentaireServiceImpl;
import com.example.demo3.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @Autowired
    ReservationService reservationservice;

    @GetMapping("/all")
    public ResponseEntity<?> getAllCommentaires() {
        try {
            List<CommentaireEntity> commentaires = commentaireService.findAll();
            return ResponseEntity.ok(commentaires);

        } catch (CommentaireException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la récupération des commentaires.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCommentaireById(@PathVariable long id) {
        try {
            commentaireService.deleteById(id);
            return ResponseEntity.ok("Commentaire supprimé avec succès.");
        }  catch (CommentaireException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la suppression du commentaire.");
        }
    }

    @GetMapping("/byReservation")
    public ResponseEntity<?> getCommentairesByReservation(@RequestParam long reservationId) {
        try {
            ReservationEntity reservation = (ReservationEntity) reservationservice.findById(reservationId).orElse(null);
            if (reservation == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Réservation non trouvée.");
            }
            List<CommentaireEntity> commentaires = commentaireService.findAllByReservation(reservation);
            return ResponseEntity.ok(commentaires);
        } catch (CommentaireException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la récupération des commentaires.");
        }
    }

    @GetMapping("/byUser")
    public List<CommentaireEntity> getCommentairesByUser(@RequestParam long userId) {
        UserEntity user = new UserEntity(); // Vous devrez obtenir l'utilisateur à partir de votre service d'utilisateur
        return commentaireService.findAllByUser(user);
    }
    @PostMapping("/create")
    public ResponseEntity<?> createCommentaire(@RequestBody CommentaireEntity commentaire) {
        try {
            CommentaireEntity createdCommentaire = commentaireService.save(commentaire);
            return ResponseEntity.ok(createdCommentaire);
        } catch (CommentaireException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la création du commentaire.");
        }
    }

    // Endpoint pour récupérer un commentaire par son ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getCommentaireById(@PathVariable long id) {
        try {
            CommentaireEntity commentaire = commentaireService.findById(id).orElse(null);
            if (commentaire == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Commentaire non trouvé.");
            }
            return ResponseEntity.ok(commentaire);
        } catch (CommentaireException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la récupération du commentaire.");
        }
    }

    // Endpoint pour mettre à jour un commentaire par son ID
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCommentaire(@PathVariable long id, @RequestBody CommentaireEntity updatedCommentaire) {
        try {
            // Logique pour mettre à jour un commentaire
            CommentaireEntity savedCommentaire = commentaireService.save(updatedCommentaire);
            return ResponseEntity.ok(savedCommentaire);
        }  catch (CommentaireException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la mise à jour du commentaire.");
        }
}}

