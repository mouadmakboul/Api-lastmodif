package com.example.demo3.Service;

import com.example.demo3.Entities.ImageEntity.ImageEntity;

import com.example.demo3.Entities.LogementEntity.LogementEntity;
import com.example.demo3.Entities.UserEntity.UserEntity;
import com.example.demo3.Exceptions.ImageException;
import com.example.demo3.Repositories.ImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {
    private final ImageRepo imageRepo;

    @Autowired
    public ImageServiceImpl(ImageRepo imageRepo) {
        this.imageRepo = imageRepo;
    }

    @Override
    public Optional<ImageEntity> findByName(String name) {
        return imageRepo.findByName(name);
    }

    @Override
    public Optional<ImageEntity> findByUserId(long id) {
        return imageRepo.findByUserId(id);
    }

    @Override
    public List<ImageEntity> findAllByLogement(LogementEntity logement) {
        return imageRepo.findAllByLogement(logement);
    }

    @Override
    public List<ImageEntity> findAllByUser(UserEntity user) {
        return imageRepo.findAllByUser(user);
    }

    @Override
    public Optional<ImageEntity> findById(Long id) {
        return imageRepo.findById(id);
    }

    @Override
    public ImageEntity save(ImageEntity image) {
        return imageRepo.save(image);
    }

    @Override
    public void deleteById(Long id) {
        imageRepo.deleteById(id);
    }

    @Override
    public ImageEntity uploadImage(MultipartFile file, UserEntity user) {
        // Assurez-vous que le fichier n'est pas vide
        if (file.isEmpty()) {
            throw new ImageException("Le fichier est vide.");
        }

        // Obtenez le nom original du fichier
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        // Créez une nouvelle instance d'ImageEntity
        ImageEntity image = new ImageEntity();
        image.setName(fileName);
        image.setUser(user); // Associez l'image à l'utilisateur

        // Enregistrez l'image dans la base de données
        image = imageRepo.save(image);

        return image;
    }}

