package com.gestao_combustivel.gestao_combustivel.Modules.Users.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthUserDTO {
    private String password;
    private String username;

}
