package com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.Entity.MovementFuel;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.Fuel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity(name = "movement_fuel")
@Data
public class MovementFuelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @NotBlank
    private MovementFuelEnum type;
    @NotBlank
    private Fuel fuel;
    @NotBlank
    private Double value;
    @NotBlank
    @CreationTimestamp
    private LocalDateTime createAt;
    @NotBlank
    private Double liters;
    @NotBlank
    private int bomb;
    @NotBlank
    private Double timeBomb;

}
