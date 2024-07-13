package com.gestao_combustivel.gestao_combustivel.Modules.Users.UseCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestao_combustivel.gestao_combustivel.Modules.Users.UserEntity;
import com.gestao_combustivel.gestao_combustivel.Modules.Users.Exceptions.UserFoundException;
import com.gestao_combustivel.gestao_combustivel.Modules.Users.Repository.UserRepository;

@Service
public class CreateUserUseCase {

    @Autowired
    private UserRepository userRepository;

    public UserEntity execute(UserEntity userEntity) {
        this.userRepository.findByUsername(userEntity.getUsername())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });
        return this.userRepository.save(userEntity);
    }

}
