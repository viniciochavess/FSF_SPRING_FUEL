package com.gestao_combustivel.gestao_combustivel.Modules.Users.Controllers;

import javax.security.sasl.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Object> session(@RequestBody AuthUserDTO authUserDTO) {
        try {
            var result = this.authUserUseCase.execute(authUserDTO);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }

    }

}
