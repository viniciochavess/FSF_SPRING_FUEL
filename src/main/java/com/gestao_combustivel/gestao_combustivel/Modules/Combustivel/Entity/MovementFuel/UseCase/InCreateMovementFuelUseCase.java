package com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.Entity.MovementFuel.UseCase;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.CombustivelEntity;
import com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.Entity.MovementFuel.MovementFuelEntity;
import com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.Entity.MovementFuel.Repositories.MovementFuelRepository;
import com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.Repositories.CombustivelRepository;

@Service
public class InCreateMovementFuelUseCase {

    @Autowired
    public MovementFuelRepository movementFuelRepository;

    @Autowired
    public CombustivelRepository combustivelRepository;

    public MovementFuelEntity execute(MovementFuelEntity movementFuelEntity) {

        Optional<CombustivelEntity> fuelOptional = this.combustivelRepository.findByFuel(movementFuelEntity.getFuel());

        if (fuelOptional != null) {
            fuelOptional.get().setTotal_liters(fuelOptional.get().getTotal_liters() + movementFuelEntity.getLiters());
            CombustivelEntity fuel = fuelOptional.get();
            this.combustivelRepository.save(fuel);

        }
        movementFuelEntity.setBomb(0);
        movementFuelEntity.setValueTotal(movementFuelEntity.getValue() * movementFuelEntity.getLiters());
        return this.movementFuelRepository.save(movementFuelEntity);

    }

}
