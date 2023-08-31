package com.example.demo3.Entities.CategoryEntity;

import com.example.demo3.Entities.LogementEntity.LogementEntity;
import com.example.demo3.Entities.PayementEntity.PayementEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "categories")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", nullable = false)
    private long id;
    private String name;
    private String image;
    @OneToMany
    private List<LogementEntity> logements;
}
