package com.gestao_combustivel.gestao_combustivel.Modules.Users.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    @GetMapping("")
    public String GetAll() {
        return "Get all Users";
    }

    @PostMapping("")
    public String Create() {
        return "Created Users";
    }

}
