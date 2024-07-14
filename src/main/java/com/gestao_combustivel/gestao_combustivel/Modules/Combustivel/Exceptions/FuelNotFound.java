package com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.Exceptions;

public class FuelNotFound extends RuntimeException {

    public FuelNotFound() {
        super("Combustivel não encontrado");
    }

}
