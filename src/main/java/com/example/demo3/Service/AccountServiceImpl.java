package com.example.demo3.Service;

import com.example.demo3.Entities.AccountEntity.AccountEntity;
import com.example.demo3.Entities.UserEntity.UserEntity;
import com.example.demo3.Repositories.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepo accountRepo;

    @Autowired
    public AccountServiceImpl(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    @Override
    public AccountEntity findByUser(UserEntity user) {
        return accountRepo.findByUser(user);
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
}
