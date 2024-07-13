package com.gestao_combustivel.gestao_combustivel.Modules.Users.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestao_combustivel.gestao_combustivel.Modules.Users.UserEntity;
import com.gestao_combustivel.gestao_combustivel.Modules.Users.UseCases.CreateUserUseCase;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private CreateUserUseCase createUserUseCase;

    @GetMapping("")
    public String GetAll() {
        return "Get all Users";
    }

    @PostMapping("")
    public ResponseEntity<Object> Create(@Valid @RequestBody UserEntity userEntity) {
        try {
            var result = this.createUserUseCase.execute(userEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
