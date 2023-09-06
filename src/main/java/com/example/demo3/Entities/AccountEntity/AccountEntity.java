package com.example.demo3.Entities.AccountEntity;

import com.example.demo3.Entities.UserEntity.UserEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;



@Entity
@Data
@Table(name = "Accounts")
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "acount_id", nullable = false)
    private long id;
    private String statut;
    private String account;

    @OneToOne
    private UserEntity user;
}
