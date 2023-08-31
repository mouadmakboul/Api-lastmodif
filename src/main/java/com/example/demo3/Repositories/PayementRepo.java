package com.example.demo3.Repositories;

import com.example.demo3.Entities.PayementEntity.PayementEntity;
import com.example.demo3.Entities.UserEntity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface PayementRepo extends JpaRepository<PayementEntity,Long> {
    List<PayementEntity> findAllByUser(UserEntity user);
    List<PayementEntity> findAllByMethodepayement(String methodepayement);



}
