package com.gestao_combustivel.gestao_combustivel.Modules.Users.Repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestao_combustivel.gestao_combustivel.Modules.Users.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    Optional<UserEntity> findByUsername(String username);
}
