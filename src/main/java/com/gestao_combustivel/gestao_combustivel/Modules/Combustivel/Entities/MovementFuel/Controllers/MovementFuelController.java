package com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.Entities.MovementFuel.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.Entities.MovementFuel.MovementFuelEntity;
import com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.Entities.MovementFuel.Repositories.MovementFuelRepository;
import com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.Entities.MovementFuel.UseCase.InCreateMovementFuelUseCase;
import com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.Entities.MovementFuel.UseCase.outCreateMovementFullUseCase;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/movimentos-combustivel")
public class MovementFuelController {

    @Autowired
    private MovementFuelRepository movementFuelRepository;

    @Autowired
    private InCreateMovementFuelUseCase inCreateMovementFuelUseCase;

    @Autowired
    outCreateMovementFullUseCase outCreateMovementFullUseCase;

    @PostMapping("/entrada")
    public ResponseEntity<Object> create(@Valid @RequestBody MovementFuelEntity movementFuelEntity) {
        try {
            if (movementFuelEntity.getType().toString() == "ENTRADA") {
                var result = this.inCreateMovementFuelUseCase.execute(movementFuelEntity);

                return ResponseEntity.ok().body(result);
            }

            return ResponseEntity.badRequest().body(null);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/saida")
    public ResponseEntity<Object> saida(@Valid @RequestBody MovementFuelEntity movementFuelEntity) {
        System.out.println(movementFuelEntity.getPerson());
        try {
            if (movementFuelEntity.getType().toString() == "SAIDA") {
                movementFuelEntity.setBomb(0);
                var result = this.outCreateMovementFullUseCase.execute(movementFuelEntity);

                return ResponseEntity.ok().body(result);
            }

            return ResponseEntity.badRequest().body(null);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/venda")
    public ResponseEntity<Object> venda(@Valid @RequestBody MovementFuelEntity movementFuelEntity) {
        try {
            if (movementFuelEntity.getType().toString() == "VENDA") {
                var result = this.outCreateMovementFullUseCase.execute(movementFuelEntity);

                return ResponseEntity.ok().body(result);
            }

            return ResponseEntity.badRequest().body(null);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping()
    public ResponseEntity<List<MovementFuelEntity>> all() {
        var result = this.movementFuelRepository.findAll();

        return ResponseEntity.ok().body(result);
    }

}
