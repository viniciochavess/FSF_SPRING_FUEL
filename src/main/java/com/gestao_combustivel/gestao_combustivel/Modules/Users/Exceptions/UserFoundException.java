package com.gestao_combustivel.gestao_combustivel.Modules.Users.Exceptions;

public class UserFoundException extends RuntimeException {

    public UserFoundException() {
        super("Usuário existe");
    }

}
