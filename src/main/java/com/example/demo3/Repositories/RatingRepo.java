package com.example.demo3.Repositories;

import com.example.demo3.Entities.LogementEntity.LogementEntity;
import com.example.demo3.Entities.RatingEntity.RatingEntity;
import com.example.demo3.Entities.UserEntity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface RatingRepo extends JpaRepository<RatingEntity,Long> {
    List<RatingEntity> findAllByLogement(LogementEntity logement);
    List<RatingEntity> findAllByUser(UserEntity user);
    void deleteById(Long id);
    RatingEntity save(RatingEntity rating);




}
