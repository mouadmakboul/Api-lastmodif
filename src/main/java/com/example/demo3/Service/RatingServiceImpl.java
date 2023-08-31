package com.example.demo3.Service;

import com.example.demo3.Entities.LogementEntity.LogementEntity;
import com.example.demo3.Entities.RatingEntity.RatingEntity;
import com.example.demo3.Entities.UserEntity.UserEntity;
import com.example.demo3.Repositories.RatingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {
    private final RatingRepo ratingRepo;

    @Autowired
    public RatingServiceImpl(RatingRepo ratingRepo) {
        this.ratingRepo = ratingRepo;
    }

    @Override
    public List<RatingEntity> findAllByLogement(LogementEntity logement) {
        return ratingRepo.findAllByLogement(logement);
    }

    @Override
    public List<RatingEntity> findAllByUser(UserEntity user) {
        return ratingRepo.findAllByUser(user);
    }

    @Override
    public void deleteById(Long id) {
        ratingRepo.deleteById(id);
    }

    @Override
    public RatingEntity save(RatingEntity rating) {
        return ratingRepo.save(rating);
    }
}
