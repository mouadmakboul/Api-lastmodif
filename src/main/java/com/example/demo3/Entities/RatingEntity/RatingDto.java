package com.example.demo3.Entities.RatingEntity;
import com.example.demo3.Entities.LogementEntity.LogementEntity;
import jakarta.persistence.*;
import lombok.Data;
@Data
public class RatingDto {
    private String rating;
    private LogementEntity logement;
}
