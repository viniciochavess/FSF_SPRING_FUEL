package com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.Entities.MovementFuel.Entities.Reports.UseCase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.Entities.MovementFuel.MovementFuelEntity;
import com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.Entities.MovementFuel.Repositories.MovementFuelRepository;

@Service
public class GetAllReportMovementFuel {

    @Autowired
    private MovementFuelRepository movementFuelRepository;

    public List<MovementFuelEntity> excecute() {

        var result = this.movementFuelRepository.findAll();
        return result;

    }

}
