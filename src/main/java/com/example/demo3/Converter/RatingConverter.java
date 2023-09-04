package com.example.demo3.Converter;

import com.example.demo3.Entities.RatingEntity.RatingDto;
import com.example.demo3.Entities.RatingEntity.RatingEntity;
import org.springframework.stereotype.Component;

@Component
public class RatingConverter {

    public RatingDto entityToDTO(RatingEntity ratingEntity) {
        return new RatingDto() {{
            setId(ratingEntity.getId());
            setRating(ratingEntity.getRating());
            setRatingvalue(ratingEntity.getRatingvalue());
            // Ajoutez d'autres propriétés de l'entité RatingEntity ici
        }};
    }
}

