package com.example.demo3.Converter;

import com.example.demo3.Entities.PayementEntity.PayementDto;
import com.example.demo3.Entities.PayementEntity.PayementEntity;
import org.springframework.stereotype.Component;

@Component
public class PayementConverter {

    public PayementDto entityToDTO(PayementEntity payementEntity) {
        return new PayementDto() {{
            setId(payementEntity.getId());
            setMethodepayement(payementEntity.getMethodepayement());
            setAmount(payementEntity.getAmount());
            // Ajoutez d'autres propriétés de l'entité PayementEntity ici
        }};
    }
}
