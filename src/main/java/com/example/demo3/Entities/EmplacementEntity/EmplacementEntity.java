package com.example.demo3.Entities.EmplacementEntity;

import com.example.demo3.Entities.LogementEntity.LogementEntity;
import com.example.demo3.Entities.RatingEntity.RatingEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "emplacements")
public class EmplacementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Emplacement_id", nullable = false)
    private long id;
    private String zonegeo;
    @OneToOne
    private LogementEntity logement;
}
