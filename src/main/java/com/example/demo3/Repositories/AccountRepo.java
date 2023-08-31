package com.example.demo3.Repositories;

import com.example.demo3.Entities.AccountEntity.AccountEntity;
import com.example.demo3.Entities.UserEntity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepo extends JpaRepository<AccountEntity, Long> {
    AccountEntity findByUser(UserEntity user);
    List<AccountEntity> findAllByStatut(String statut);
    Long countByStatut(String statut);
    void deleteById(Long id); // Méthode de suppression par ID
    AccountEntity save(AccountEntity account); // Méthode de mise à jour
}
