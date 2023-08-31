package com.example.demo3.Service;


import com.example.demo3.Entities.ImageEntity.ImageEntity;
import com.example.demo3.Entities.LogementEntity.LogementEntity;
import com.example.demo3.Entities.UserEntity.UserEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface ImageService {
    Optional<ImageEntity> findByName(String name);
    Optional<ImageEntity> findByUserId(long id);
    List<ImageEntity> findAllByLogement(LogementEntity logement);
    List<ImageEntity> findAllByUser(UserEntity user);

    Optional<ImageEntity> findById(Long id); // Nouvelle méthode pour rechercher une image par ID

    ImageEntity save(ImageEntity image); // Nouvelle méthode pour sauvegarder une image

    void deleteById(Long id); // Nouvelle méthode pour supprimer une image par ID
    public ImageEntity uploadImage(MultipartFile file, UserEntity user);
}

