package com.example.demo3.controllers;

import com.example.demo3.Entities.PayementEntity.PayementEntity;
import com.example.demo3.Entities.UserEntity.UserEntity;
import com.example.demo3.Service.PayementService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Optional<PayementEntity> getPayementById(@PathVariable Long id) {
        return payementService.findById(id);
    }

    @PostMapping("/save")
    public PayementEntity savePayement(@RequestBody PayementEntity payement) {
        return payementService.save(payement);
    }

    @DeleteMapping("/{id}")
    public void deletePayement(@PathVariable Long id) {
        payementService.deleteById(id);
    }
}
