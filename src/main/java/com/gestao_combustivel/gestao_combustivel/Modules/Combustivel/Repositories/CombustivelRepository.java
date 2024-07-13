package com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.CombustivelEntity;
import com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.Fuel;

public interface CombustivelRepository extends JpaRepository<CombustivelEntity, Long> {

    Optional<CombustivelEntity> findByFuel(Fuel fuel);

}
