package com.example.demo3.controllers;

import com.example.demo3.Entities.LogementEntity.LogementEntity;
import com.example.demo3.Entities.ReservationEntity.ReservationEntity;
import com.example.demo3.Entities.UserEntity.UserEntity;
import com.example.demo3.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{username}")
    public Optional<UserEntity> getUserByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @GetMapping("/existsByUsername/{username}")
    public Boolean existsByUsername(@PathVariable String username) {
        return userService.existsByUsername(username);
    }

    @GetMapping("/existsByEmail/{email}")
    public Boolean existsByEmail(@PathVariable String email) {
        return userService.existsByEmail(email);
    }
    @GetMapping("/{userId}/logements")
    public List<LogementEntity> getLogementsByUser(@PathVariable Long userId) {
        UserEntity user = userService.findById(userId); // Supposons que vous ayez une méthode findById dans votre service
        return userService.getLogementsByUser(user);
    }

    @GetMapping("/{userId}/reservations")
    public List<ReservationEntity> getReservationsByUser(@PathVariable Long userId) {
        UserEntity user = userService.findById(userId); // Supposons que vous ayez une méthode findById dans votre service
        return userService.getReservationsByUser(user);
    }
}
