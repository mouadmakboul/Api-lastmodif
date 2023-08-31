package com.example.demo3.Entities.ReservationEntity;
import com.example.demo3.Entities.CommentaireEntity.CommentaireEntity;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;
import java.util.List;
@Data


@Getter
@Setter
@NoArgsConstructor
public class ReservationDto {


    @NotNull
    @NotEmpty
    private Date Datereservation;

    private String firstName;
     private List<CommentaireEntity> commentaires;

}
