package com.example.demo3.controllers;

import com.example.demo3.Entities.ImageEntity.ImageEntity;
import com.example.demo3.Entities.LogementEntity.LogementEntity;
import com.example.demo3.Entities.UserEntity.UserEntity;
import com.example.demo3.Exceptions.ImageException;
import com.example.demo3.Service.ImageService;
import com.example.demo3.Service.ImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/images")
public class ImageController {

    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/byName")
    public ResponseEntity<?> getImageByName(@RequestParam String name) {
        try {
            Optional<ImageEntity> image = imageService.findByName(name);
            if (image.isPresent()) {
                return ResponseEntity.ok(image.get());
            } else {
                throw new ImageException("Image not found with name: " + name);
            }
        } catch (ImageException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }



    @GetMapping("/byUserId")
    public ResponseEntity<?> getImageByUserId(@RequestParam long userId) {
        try {
            Optional<ImageEntity> image = imageService.findByUserId(userId);
            if (image.isPresent()) {
                return ResponseEntity.ok(image.get());
            } else {
                throw new ImageException("Image not found for user with ID: " + userId);
            }
        } catch (ImageException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @GetMapping("/byLogement")
    public List<ImageEntity> getImagesByLogement(@RequestParam long logementId) {
        LogementEntity logement = new LogementEntity(); // Vous devrez obtenir le logement à partir de votre service de logement
        return imageService.findAllByLogement(logement);
    }

    @GetMapping("/byUser")
    public List<ImageEntity> getImagesByUser(@RequestParam long userId) {
        UserEntity user = new UserEntity(); // Vous devrez obtenir l'utilisateur à partir de votre service d'utilisateur
        return imageService.findAllByUser(user);
    }
    @GetMapping("/{id}")
    public Optional<ImageEntity> getImageById(@PathVariable Long id) {
        return imageService.findById(id);
    }

    @PostMapping
    public ImageEntity createImage(@RequestBody ImageEntity image) {
        return imageService.save(image);
    }

    @PutMapping("/{id}")
    public ImageEntity updateImage(@PathVariable Long id, @RequestBody ImageEntity updatedImage) {

        return imageService.save(updatedImage);
    }

    @DeleteMapping("/{id}")
    public void deleteImage(@PathVariable Long id) {
        imageService.deleteById(id);
    }
    @PostMapping("/upload")
    public ResponseEntity<?> uploadImage(
            @RequestParam("file") MultipartFile file,
            @RequestParam("userId") long userId) {
        UserEntity user = new UserEntity(); // Vous devrez obtenir l'utilisateur à partir de votre service d'utilisateur

        try {
            ImageEntity uploadedImage = imageService.uploadImage(file, user);
            return new ResponseEntity<>(uploadedImage, HttpStatus.CREATED);
        } catch (ImageException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }}
