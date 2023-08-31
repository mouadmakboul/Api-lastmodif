package com.example.demo3.Entities.ReservationEntity;

import com.example.demo3.Entities.CommentaireEntity.CommentaireEntity;
import com.example.demo3.Entities.LogementEntity.LogementEntity;
import com.example.demo3.Entities.PayementEntity.PayementEntity;
import com.example.demo3.Entities.UserEntity.UserEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "reservations")
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id", nullable = false)
    private long id;

    private Date Datereservation;
    private Date startDate;
    private Date endtDate;

    @OneToMany(mappedBy = "reservation", fetch = FetchType.LAZY)
    private List<CommentaireEntity> commentaire;

    @OneToOne
    private PayementEntity payement;

    @ManyToOne // Correction : Relation ManyToOne avec LogementEntity
    @JoinColumn(name = "logement_id") // Correction : spécification de la colonne de jointure
    private LogementEntity logement;

    @ManyToOne // Correction : Relation ManyToOne avec UserEntity
    @JoinColumn(name = "user_id") // Correction : spécification de la colonne de jointure
    private UserEntity user;
}
