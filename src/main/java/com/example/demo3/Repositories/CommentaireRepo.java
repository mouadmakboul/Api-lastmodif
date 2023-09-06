package com.example.demo3.Repositories;

import com.example.demo3.Entities.CommentaireEntity.CommentaireEntity;
import com.example.demo3.Entities.ReservationEntity.ReservationEntity;
import com.example.demo3.Entities.UserEntity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentaireRepo extends JpaRepository<CommentaireEntity,Long> {


    List<CommentaireEntity> findAll();
    void deleteById(long id);
    List<CommentaireEntity> findAllByReservation(ReservationEntity reservation);
    List<CommentaireEntity> findAllByUser(UserEntity user);



}
