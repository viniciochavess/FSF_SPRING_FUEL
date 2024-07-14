package com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.Exceptions;

public class ErrorRouterFoundNot extends RuntimeException {

    public ErrorRouterFoundNot() {
        super("Rota não existe ou o parâmetro está incorreto");
    }

}
