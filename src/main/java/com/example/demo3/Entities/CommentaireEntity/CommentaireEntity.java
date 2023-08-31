package com.example.demo3.Entities.CommentaireEntity;

import com.example.demo3.Entities.RatingEntity.RatingEntity;
import com.example.demo3.Entities.ReservationEntity.ReservationEntity;
import com.example.demo3.Entities.UserEntity.UserEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "comments")
public class CommentaireEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commentaire_id", nullable = false)
    private long id;
    private String text;
    private Date sendDate;


    private boolean way;

    private boolean seen;
    @OneToOne

    private UserEntity user;
    @ManyToOne
    private ReservationEntity reservation;


}
