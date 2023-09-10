package com.example.demo3.Service;

import com.example.demo3.Converter.AccountConverter;
import com.example.demo3.Entities.AccountEntity.AccountDto;
import com.example.demo3.Entities.AccountEntity.AccountEntity;
import com.example.demo3.Entities.UserEntity.UserEntity;
import com.example.demo3.Exceptions.AccountException;
import com.example.demo3.Repositories.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepo accountRepo;
    private final AccountConverter accountConverter;

    @Autowired
    public AccountServiceImpl(AccountRepo accountRepo, AccountConverter accountConverter) {
        this.accountRepo = accountRepo;
        this.accountConverter = accountConverter;
    }

    @Override
    public AccountEntity findByUser(UserEntity user) {
        AccountEntity account = accountRepo.findByUser(user);
        if (account == null) {
            throw new AccountException("Le compte de l'utilisateur spécifié n'a pas été trouvé.");
        }
        return account;
    }


    @Override
    public List<AccountEntity> findAllByStatut(String statut) {
        return accountRepo.findAllByStatut(statut);
    }

    @Override
    public Long countByStatut(String statut) {
        return accountRepo.countByStatut(statut);
    }

    @Override
    public void deleteById(Long id) {
        accountRepo.deleteById(id);
    }

    @Override
    public AccountEntity updateAccount(AccountEntity account) {
        return accountRepo.save(account);
    }
    public AccountDto entityToDTO(AccountEntity accountEntity) {
        return accountConverter.entityToDTO(accountEntity);
    }
}
