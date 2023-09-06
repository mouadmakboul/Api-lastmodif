package com.example.demo3.controllers;

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

@RestController
@RequestMapping("/payements")
public class PayementController {

    private final PayementService payementService;

    @Autowired
    public PayementController(PayementService payementService) {
        this.payementService = payementService;
    }

    @GetMapping("/byUser")
    public List<PayementEntity> getPayementsByUser(@RequestParam long userId) {
        UserEntity user = new UserEntity(); // Vous devrez obtenir l'utilisateur à partir de votre service d'utilisateur
        return payementService.findAllByUser(user);
    }

    @GetMapping("/byMethodepayement")
    public List<PayementEntity> getPayementsByMethodePayement(@RequestParam String methodepayement) {
        return payementService.findAllByMethodepayement(methodepayement);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getPayementById(@PathVariable Long id) {
        try {
            Optional<PayementEntity> payement = payementService.findById(id);
            if (payement.isPresent()) {
                return ResponseEntity.ok(payement.get());
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
            // Effectuez ici des validations de paiement, si nécessaire
            PayementEntity savedPayement = payementService.save(payement);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedPayement);
        } catch (PaymentException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }


    @DeleteMapping("/{id}")
    public void deletePayement(@PathVariable Long id) {
        payementService.deleteById(id);
    }
}
