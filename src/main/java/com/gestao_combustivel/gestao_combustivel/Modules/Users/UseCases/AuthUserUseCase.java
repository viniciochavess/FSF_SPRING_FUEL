package com.gestao_combustivel.gestao_combustivel.Modules.Users.UseCases;

import javax.security.sasl.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gestao_combustivel.gestao_combustivel.Modules.Users.Repository.UserRepository;
import com.gestao_combustivel.gestao_combustivel.Modules.Users.dto.AuthUserDTO;



@Service
public class AuthUserUseCase {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void execute(AuthUserDTO authUserDTO) throws AuthenticationException {

        var result = this.userRepository.findByUsername(authUserDTO.getUsername()).orElseThrow(()->{
            throw new UsernameNotFoundException("Erro nas credenciais");
        });

       var passwordMatches = this.passwordEncoder.matches(authUserDTO.getPassword(), result.getPassword());

       if (!passwordMatches) {
            throw new AuthenticationException();
       }
       
    }

}
