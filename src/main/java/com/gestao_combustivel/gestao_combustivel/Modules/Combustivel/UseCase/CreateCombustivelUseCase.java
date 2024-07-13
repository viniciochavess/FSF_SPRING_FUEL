package com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.UseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.CombustivelEntity;
import com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.Exceptions.FuelFoundExist;
import com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.Repositories.CombustivelRepository;

@Service
public class CreateCombustivelUseCase {

    @Autowired
    private CombustivelRepository combustivelRepository;

    public CombustivelEntity execute(CombustivelEntity combustivelEntity) {

        this.combustivelRepository.findByFuel(combustivelEntity.getFuel())
                .ifPresent((user -> {
                    throw new FuelFoundExist();
                }));
        return this.combustivelRepository.save(combustivelEntity);

    }
}
