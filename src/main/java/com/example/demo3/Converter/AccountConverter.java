package com.example.demo3.Converter;

import com.example.demo3.Entities.AccountEntity.AccountDto;
import com.example.demo3.Entities.AccountEntity.AccountEntity;
import org.springframework.stereotype.Component;

@Component
public class AccountConverter {

    public AccountDto entityToDTO(AccountEntity accountEntity) {
        return new AccountDto() {{
            setId(accountEntity.getId());
            setStatut(accountEntity.getStatut());
            setAccount(accountEntity.getAccount());
            // Ajoutez d'autres propriétés de l'entité AccountEntity ici
        }};
    }
}

