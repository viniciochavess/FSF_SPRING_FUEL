package com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.Entity.MovementFuel.UseCase;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.CombustivelEntity;
import com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.Entity.MovementFuel.MovementFuelEntity;
import com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.Entity.MovementFuel.Exceptions.FuelNotLitersZero;
import com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.Entity.MovementFuel.Repositories.MovementFuelRepository;
import com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.Repositories.CombustivelRepository;

@Service
public class outCreateMovementFullUseCase {

    @Autowired
    public MovementFuelRepository movementFuelRepository;

    @Autowired
    public CombustivelRepository combustivelRepository;

    public MovementFuelEntity execute(MovementFuelEntity movementFuelEntity) {
        Double validateLitersZero = 0.0;
        Optional<CombustivelEntity> fuelOptional = this.combustivelRepository.findByFuel(movementFuelEntity.getFuel());

        if (fuelOptional != null) {

            validateLitersZero = fuelOptional.get().getTotal_liters() - movementFuelEntity.getLiters();
            if (validateLitersZero < 0) {
                throw new FuelNotLitersZero();
            }
            fuelOptional.get().setTotal_liters(validateLitersZero);
            CombustivelEntity fuel = fuelOptional.get();

            this.combustivelRepository.save(fuel);

            return this.movementFuelRepository.save(movementFuelEntity);

        }

        throw new FuelNotLitersZero();

    }

}
