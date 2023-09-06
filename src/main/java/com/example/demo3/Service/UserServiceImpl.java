package com.example.demo3.Service;

import com.example.demo3.Entities.LogementEntity.LogementEntity;
import com.example.demo3.Entities.ReservationEntity.ReservationEntity;
import com.example.demo3.Entities.UserEntity.UserEntity;

import com.example.demo3.Exceptions.UserException;
import com.example.demo3.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepository;

    @Autowired
    public UserServiceImpl(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<UserEntity> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public List<LogementEntity> getLogementsByUser(UserEntity user) {
        // Implémentez la logique pour récupérer les logements d'un utilisateur spécifique
        return user.getLogements();
    }

    @Override
    public List<ReservationEntity> getReservationsByUser(UserEntity user) {
        // Implémentez la logique pour récupérer les réservations d'un utilisateur spécifique
        return user.getReservation();
    }

    @Override
    public UserEntity findById(Long userId) {
        Optional<UserEntity> userOptional = userRepository.findById(userId);

        if (userOptional.isPresent()) {
            return userOptional.get();
        } else {
            throw new UserException("Utilisateur introuvable pour l'ID : " + userId);
        }
    }

    public UserEntity saveUser(UserEntity user) {

        return userRepository.save(user);
    }


}
