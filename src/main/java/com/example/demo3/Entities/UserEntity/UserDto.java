package com.example.demo3.Entities.UserEntity;

import com.example.demo3.Entities.AccountEntity.AccountEntity;
import com.example.demo3.Entities.CommentaireEntity.CommentaireEntity;
import com.example.demo3.Entities.PayementEntity.PayementEntity;
import com.example.demo3.Entities.ReservationEntity.ReservationEntity;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    private String username;

    private String firstName;

    private List<CommentaireEntity> commentaires;
    private List<PayementEntity> payements;
    private List<ReservationEntity> resevations;

}
