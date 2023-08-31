package com.example.demo3.Repositories;

import com.example.demo3.Entities.ImageEntity.ImageEntity;
import com.example.demo3.Entities.LogementEntity.LogementEntity;
import com.example.demo3.Entities.UserEntity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ImageRepo extends JpaRepository<ImageEntity,Long> {
    Optional<ImageEntity> findByName(String name);
    Optional<ImageEntity> findByUserId(long id);
    List<ImageEntity> findAllByLogement(LogementEntity logement);
    List<ImageEntity> findAllByUser(UserEntity user);


}
