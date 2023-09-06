package com.example.demo3.Repositories;

import com.example.demo3.Entities.CategoryEntity.CategoryEntity;
import com.example.demo3.Entities.LogementEntity.LogementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepo extends JpaRepository<CategoryEntity,Long> {
    CategoryEntity findByName(String name);
    List<CategoryEntity> findAllByLogementsContains(Optional<LogementEntity> logement);
    boolean existsByName(String name);

}
