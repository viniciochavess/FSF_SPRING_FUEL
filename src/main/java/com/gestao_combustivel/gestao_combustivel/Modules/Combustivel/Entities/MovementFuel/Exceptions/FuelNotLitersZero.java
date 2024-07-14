package com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.Entities.MovementFuel.Exceptions;

public class FuelNotLitersZero extends RuntimeException {
    public FuelNotLitersZero() {
        super("Saída ou a venda é superior ao estoque");
    }
}
