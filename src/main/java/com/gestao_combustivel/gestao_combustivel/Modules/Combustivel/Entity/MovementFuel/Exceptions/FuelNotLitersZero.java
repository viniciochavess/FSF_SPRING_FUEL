package com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.Entity.MovementFuel.Exceptions;

public class FuelNotLitersZero extends RuntimeException {
    public FuelNotLitersZero() {
        super("Saída ou a venda é superior ao estoque");
    }
}
