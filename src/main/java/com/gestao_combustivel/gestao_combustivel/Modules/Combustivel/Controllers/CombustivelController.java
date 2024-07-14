package com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.CombustivelEntity;
import com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.Repositories.CombustivelRepository;
import com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.UseCase.CreateCombustivelUseCase;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/combustivel")
public class CombustivelController {

    @Autowired
    private CombustivelRepository combustivelRepository;

    @Autowired
    private CreateCombustivelUseCase createCombustivelUseCase;

    @PostMapping("")
    public ResponseEntity<Object> Create(@Valid @RequestBody CombustivelEntity combustivelEntity) {
        try {
            var result = this.createCombustivelUseCase.execute(combustivelEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("")
    public ResponseEntity<List<CombustivelEntity>> GetAll() {
        List<CombustivelEntity> result = combustivelRepository.findAll();
        return ResponseEntity.ok().body(result);
    }

}
