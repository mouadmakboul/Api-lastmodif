package com.example.demo3.Service;

import com.example.demo3.Entities.CommentaireEntity.CommentaireEntity;
import com.example.demo3.Entities.ReservationEntity.ReservationEntity;
import com.example.demo3.Entities.UserEntity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface CommentaireService {

    List<CommentaireEntity> findAll();

    void deleteById(long id);

    List<CommentaireEntity> findAllByReservation(ReservationEntity reservation);

    List<CommentaireEntity> findAllByUser(UserEntity user);

    // Redéfinition de la méthode save

    CommentaireEntity save(CommentaireEntity reservation);

    Optional<CommentaireEntity> findById(long id);
}
