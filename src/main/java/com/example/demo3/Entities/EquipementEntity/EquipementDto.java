package com.example.demo3.Entities.EquipementEntity;

import com.example.demo3.Entities.LogementEntity.LogementDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Data
public class EquipementDto {
    private long id;
    private String nameEquipement;
    private String img;
    private LogementDto logement; // Utilisez un DTO pour le logement associé, par exemple, LogementDto
}
