package com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.Exceptions;

public class FuelFoundExist extends RuntimeException {

    public FuelFoundExist() {
        super("Combustivel Existe");
    }
}
