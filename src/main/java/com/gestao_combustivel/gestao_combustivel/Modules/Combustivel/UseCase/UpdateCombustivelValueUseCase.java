package com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.UseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.CombustivelEntity;
import com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.Communications.UpdateValueJSON;
import com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.Exceptions.FuelNotFound;
import com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.Repositories.CombustivelRepository;

import lombok.var;

@Service
public class UpdateCombustivelValueUseCase {

    @Autowired
    private CombustivelRepository combustivelRepository;

    public CombustivelEntity execute(UpdateValueJSON updateValueJSON) {

        var result = this.combustivelRepository.findByFuel(updateValueJSON.getName());

        if (result.isPresent() == false) {
            throw new FuelNotFound();
        }
        result.get().setCurrentValue(updateValueJSON.getValue());
        CombustivelEntity newResult = result.get();
        return this.combustivelRepository.save(newResult);

    }

}
