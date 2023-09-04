package com.example.demo3.Entities.ImageEntity;

import com.example.demo3.Entities.LogementEntity.LogementEntity;
import com.example.demo3.Entities.RatingEntity.RatingEntity;
import com.example.demo3.Entities.UserEntity.UserEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "images")
public class ImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Image_id", nullable = false)
    private long id;
    private String path;
    private String name;
    private String type;
    @OneToOne
    private LogementEntity logement;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="user_id", nullable = true)
    private UserEntity user;

}
