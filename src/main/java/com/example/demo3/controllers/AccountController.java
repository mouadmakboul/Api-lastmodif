package com.example.demo3.controllers;

import com.example.demo3.Entities.AccountEntity.AccountEntity;
import com.example.demo3.Entities.UserEntity.UserEntity;
import com.example.demo3.Service.AccountService;
import com.example.demo3.Service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/byUser")
    public AccountEntity getAccountByUser(@RequestParam long userId) {
        UserEntity user = new UserEntity(); // Vous devrez obtenir l'utilisateur à partir de votre service d'utilisateur
        return accountService.findByUser(user);
    }

    @GetMapping("/byStatut")
    public List<AccountEntity> getAccountsByStatut(@RequestParam String statut) {
        return accountService.findAllByStatut(statut);
    }

    @GetMapping("/countByStatut")
    public Long countAccountsByStatut(@RequestParam String statut) {
        return accountService.countByStatut(statut);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Long id) {
        accountService.deleteById(id);
    }

    @PutMapping("/{id}")
    public AccountEntity updateAccount(@PathVariable Long id, @RequestBody AccountEntity updatedAccount) {
        return accountService.updateAccount(updatedAccount);
    }

}

