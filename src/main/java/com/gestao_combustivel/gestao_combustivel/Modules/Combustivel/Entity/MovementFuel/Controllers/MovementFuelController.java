package com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.Entity.MovementFuel.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.Entity.MovementFuel.MovementFuelEntity;
import com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.Entity.MovementFuel.UseCase.CreateMovementFuelUseCase;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/movimentos-combustivel")
public class MovementFuelController {

    @Autowired
    private CreateMovementFuelUseCase createMovementFuelUseCase;

    @PostMapping("")
    public ResponseEntity<Object> create(@Valid @RequestBody MovementFuelEntity movementFuelEntity) {
        try {
            var result = this.createMovementFuelUseCase.execute(movementFuelEntity);
            return ResponseEntity.ok().body(result);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
