package com.example.demo3.controllers;

import com.example.demo3.Converter.UserConverter;
import com.example.demo3.Entities.LogementEntity.LogementEntity;
import com.example.demo3.Entities.ReservationEntity.ReservationEntity;
import com.example.demo3.Entities.UserEntity.UserDto;
import com.example.demo3.Entities.UserEntity.UserEntity;
import com.example.demo3.Exceptions.UserException;
import com.example.demo3.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final UserConverter userConverter; // Injectez UserConverter

    @Autowired
    public UserController(UserService userService, UserConverter userConverter) {
        this.userService = userService;
        this.userConverter = userConverter;
    }



    @GetMapping("/{username}")
    public ResponseEntity<?> getUserByUsername(@PathVariable String username) {
        try {
            Optional<UserEntity> user = userService.findByUsername(username);
            if (user.isPresent()) {
                // Utilisez UserConverter pour convertir l'entité en DTO
                UserDto userDto = userConverter.entityToDTO(user.get());
                return ResponseEntity.ok(userDto);
            } else {
                throw new UserException("Utilisateur non trouvé avec le nom d'utilisateur : " + username);
            }
        } catch (UserException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @GetMapping("/existsByEmail/{email}")
    public Boolean existsByEmail(@PathVariable String email) {
        return userService.existsByEmail(email);
    }



    @GetMapping("/{userId}/logements")
    public List<LogementEntity> getLogementsByUser(@PathVariable Long userId) {
        UserEntity user = userService.findById(userId);
        return userService.getLogementsByUser(user);
    }

    @GetMapping("/{userId}/reservations")
    public List<ReservationEntity> getReservationsByUser(@PathVariable Long userId) {
        UserEntity user = userService.findById(userId);
        return userService.getReservationsByUser(user);
    }
    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@RequestBody UserEntity user) {
        try {

            UserEntity savedUser = userService.saveUser(user);



            UserDto userDto = userConverter.entityToDTO(savedUser);

            return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
        } catch (UserException ex) {
            throw new UserException("une erreur s'est produite lors de la création");
        }
    }


}
