package com.gestao_combustivel.gestao_combustivel.Modules.Users.Controllers;

import javax.security.sasl.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestao_combustivel.gestao_combustivel.Modules.Users.UseCases.AuthUserUseCase;
import com.gestao_combustivel.gestao_combustivel.Modules.Users.dto.AuthUserDTO;

@RestController
@RequestMapping("/session")
public class AuthUserController {

    @Autowired
    private AuthUserUseCase authUserUseCase;

    @PostMapping
    public String session(@RequestBody AuthUserDTO authUserDTO) throws AuthenticationException {
        var result = this.authUserUseCase.execute(authUserDTO);
        return result;

    }

}
