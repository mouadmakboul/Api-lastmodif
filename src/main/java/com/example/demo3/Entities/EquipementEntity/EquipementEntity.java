package com.example.demo3.Entities.EquipementEntity;

import com.example.demo3.Entities.LogementEntity.LogementEntity;
import com.example.demo3.Entities.RatingEntity.RatingEntity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "equipements")
public class EquipementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Equipement_id", nullable = false)
    private long id;
    private String nameEquipement;
    private String img;
    @OneToOne
    private LogementEntity logement;
}
