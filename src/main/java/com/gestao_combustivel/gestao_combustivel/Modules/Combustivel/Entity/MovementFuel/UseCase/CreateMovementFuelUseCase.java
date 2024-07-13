package com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.Entity.MovementFuel.UseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.Entity.MovementFuel.MovementFuelEntity;
import com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.Entity.MovementFuel.Repositories.MovementFuelRepository;

@Service
public class CreateMovementFuelUseCase {

    @Autowired
    public MovementFuelRepository movementFuelRepository;

    public MovementFuelEntity execute(MovementFuelEntity movementFuelEntity) {
        return this.movementFuelRepository.save(movementFuelEntity);

    }

}
