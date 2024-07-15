package com.gestao_combustivel.gestao_combustivel.Modules.Users.UseCases;

import javax.security.sasl.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.gestao_combustivel.gestao_combustivel.Modules.Users.Repository.UserRepository;
import com.gestao_combustivel.gestao_combustivel.Modules.Users.dto.AuthUserDTO;

@Service
public class AuthUserUseCase {
    @Value("${security.token.secret}")
    private String secretKey;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String execute(AuthUserDTO authUserDTO) throws AuthenticationException {

        var result = this.userRepository.findByUsername(authUserDTO.getUsername()).orElseThrow(() -> {
            throw new UsernameNotFoundException("Erro nas credenciais");
        });

        var passwordMatches = this.passwordEncoder.matches(authUserDTO.getPassword(), result.getPassword());

        if (!passwordMatches) {
            throw new AuthenticationException();
        }
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        var token = JWT.create().withIssuer("posto")
                .withSubject(result.getId().toString())
                .sign(algorithm);
        return token;
    }

}
