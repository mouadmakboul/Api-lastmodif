package com.example.demo3.Converter;

import com.example.demo3.Entities.EmplacementEntity.EmplacementDto;
import com.example.demo3.Entities.EmplacementEntity.EmplacementEntity;
import org.springframework.stereotype.Component;

@Component
public class EmplacementConverter {

    public EmplacementDto entityToDTO(EmplacementEntity emplacementEntity) {
        return new EmplacementDto() {{
            setId(emplacementEntity.getId());
            setZonegeo(emplacementEntity.getZonegeo());
            // Ajoutez d'autres propriétés de l'entité EmplacementEntity ici
        }};
    }
}

