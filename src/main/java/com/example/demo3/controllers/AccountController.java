package com.example.demo3.controllers;

import com.example.demo3.Entities.AccountEntity.AccountEntity;
import com.example.demo3.Entities.UserEntity.UserEntity;
import com.example.demo3.Exceptions.AccountException;
import com.example.demo3.Exceptions.UserException;
import com.example.demo3.Service.AccountService;
import com.example.demo3.Service.AccountServiceImpl;
import com.example.demo3.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;


@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    @Autowired
    private UserService userService;

    @GetMapping("/byUser")
    public ResponseEntity<?> getAccountByUser(@RequestParam long userId) {
        UserEntity user = userService.findById(userId); // Obtenez l'utilisateur à partir de votre service d'utilisateur
        if (user == null) {
            throw new UserException("L'utilisateur avec l'ID " + userId + " n'a pas été trouvé.");
        }

        AccountEntity account = accountService.findByUser(user);
        if (account == null) {
            throw new AccountException("Aucun compte n'a été trouvé pour cet utilisateur.");
        }

        return ResponseEntity.ok(account);
    }


    @GetMapping("/byStatut")
    public ResponseEntity<?> getAccountsByStatut(@RequestParam String statut) {
        List<AccountEntity> accounts = accountService.findAllByStatut(statut);
        if (accounts.isEmpty()) {
            throw new AccountException("Aucun compte n'a été trouvé pour le statut spécifié.");
        }
        return ResponseEntity.ok(accounts);
    }

    @GetMapping("/countByStatut")
    public ResponseEntity<?> countAccountsByStatut(@RequestParam String statut) {
        Long count = accountService.countByStatut(statut);
        if (count == 0) {
            throw new AccountException("Aucun compte n'a été trouvé pour le statut spécifié.");
        }
        return ResponseEntity.ok(count);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable Long id) {
        try {
            accountService.deleteById(id);
            return ResponseEntity.ok("Compte supprimé avec succès.");
        } catch (Exception e) {
            throw new AccountException("La suppression du compte a échoué : " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public AccountEntity updateAccount(@PathVariable Long id, @RequestBody AccountEntity updatedAccount) {
        return accountService.updateAccount(updatedAccount);
    }

}

