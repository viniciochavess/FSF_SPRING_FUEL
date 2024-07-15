package com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.Entities.MovementFuel.Entities.Reports.Repositories;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.Entities.MovementFuel.MovementFuelEntity;
import com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.Entities.MovementFuel.MovementFuelEnum;

public interface ReportMovementFuelRepository extends JpaRepository<MovementFuelEntity, Long> {
    Optional<MovementFuelEntity> findByFuel(String fuel);

    List<MovementFuelEntity> findByCreateAt(LocalDateTime createAt);

    List<MovementFuelEntity> findByFuelAndTypeAndCreateAtBetween(String fuel, MovementFuelEnum type,
            LocalDateTime startDateTime,
            LocalDateTime endDateTime);

}
