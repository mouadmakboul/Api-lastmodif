package com.example.demo3.Entities.PayementEntity;

import com.example.demo3.Entities.ReservationEntity.ReservationEntity;
import com.example.demo3.Entities.UserEntity.UserEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "payements")
public class PayementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payement_id", nullable = false)
    private long id;
    private String methodepayement;
    @OneToOne
    private UserEntity user;
    @OneToOne
    private ReservationEntity reservation;
}
