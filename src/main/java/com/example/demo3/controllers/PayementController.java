package com.example.demo3.controllers;

import com.example.demo3.Converter.PayementConverter;
import com.example.demo3.Entities.PayementEntity.PayementDto;
import com.example.demo3.Entities.PayementEntity.PayementEntity;
import com.example.demo3.Entities.UserEntity.UserEntity;
import com.example.demo3.Exceptions.PaymentException;
import com.example.demo3.Service.PayementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/payements")
public class PayementController {

    private final PayementService payementService;
    private final PayementConverter payementConverter; // Injectez PayementConverter

    @Autowired
    public PayementController(PayementService payementService, PayementConverter payementConverter) {
        this.payementService = payementService;
        this.payementConverter = payementConverter;
    }

    @GetMapping("/byUser")
    public ResponseEntity<?> getPayementsByUser(@RequestBody UserEntity user) {

        try {
            List<PayementEntity> payements = payementService.findAllByUser(user);

            // Utilisez PayementConverter pour convertir les entités en DTOs
            List<PayementDto> payementDtos = payements.stream()
                    .map(payementConverter::entityToDTO)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(payementDtos);
        } catch (PaymentException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la récupération des paiements.");
        }
    }

    @GetMapping("/byMethodepayement")
    public ResponseEntity<?> getPayementsByMethodePayement(@RequestParam String methodepayement) {
        try {
            List<PayementEntity> payements = payementService.findAllByMethodepayement(methodepayement);

            // Utilisez PayementConverter pour convertir les entités en DTOs
            List<PayementDto> payementDtos = payements.stream()
                    .map(payementConverter::entityToDTO)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(payementDtos);
        } catch (PaymentException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la récupération des paiements.");
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getPayementById(@PathVariable Long id) {
        try {
            Optional<PayementEntity> payementOptional = payementService.findById(id);
            if (payementOptional.isPresent()) {
                PayementEntity payement = payementOptional.get();

                // Utilisez PayementConverter pour convertir l'entité en DTO
                PayementDto payementDto = payementConverter.entityToDTO(payement);

                return ResponseEntity.ok(payementDto);
            } else {
                throw new PaymentException("Paiement non trouvé avec l'ID : " + id);
            }
        } catch (PaymentException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> savePayement(@RequestBody PayementEntity payement) {
        try {

            PayementEntity savedPayement = payementService.save(payement);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedPayement);
        } catch (PaymentException ex) {
            throw new PaymentException("Erreur de creation du payement.");
        }
    }


    @DeleteMapping("/{id}")
    public void deletePayement(@PathVariable Long id) {
        payementService.deleteById(id);
    }
}
