package com.example.demo3.Service;

import com.example.demo3.Entities.LogementEntity.LogementEntity;
import com.example.demo3.Entities.RatingEntity.RatingEntity;
import com.example.demo3.Entities.UserEntity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface RatingService {
    List<RatingEntity> findAllByLogement(LogementEntity logement);
    List<RatingEntity> findAllByUser(UserEntity user);
    void deleteById(Long id);
    RatingEntity save(RatingEntity rating);

    Optional<RatingEntity> findById(Long id);
}
