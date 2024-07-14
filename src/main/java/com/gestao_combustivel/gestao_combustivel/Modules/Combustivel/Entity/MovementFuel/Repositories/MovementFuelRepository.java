package com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.Entity.MovementFuel.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.Entity.MovementFuel.MovementFuelEntity;

public interface MovementFuelRepository extends JpaRepository<MovementFuelEntity, Long> {

    Optional<MovementFuelEntity> findByFuel(String fuel);

}
