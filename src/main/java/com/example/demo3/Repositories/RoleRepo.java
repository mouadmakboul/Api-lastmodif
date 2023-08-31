package com.example.demo3.Repositories;

import com.example.demo3.Entities.UserEntity.ERole;
import com.example.demo3.Entities.UserEntity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface RoleRepo extends JpaRepository<Role,Integer> {
    Optional<Role> findByName(ERole name);

}
