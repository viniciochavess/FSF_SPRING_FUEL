package com.gestao_combustivel.gestao_combustivel.Modules.Users;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Length(min = 6, max = 255)
    @NotBlank
    private String name;

    @NotBlank
    @Pattern(regexp = "^(?!\\s*$).+", message = "O campo [username] não deve ter espaço")

    private String username;
    @NotBlank
    private String password;

    @Column(name = "create_at")
    @CreationTimestamp
    private LocalDateTime createAt;

}
