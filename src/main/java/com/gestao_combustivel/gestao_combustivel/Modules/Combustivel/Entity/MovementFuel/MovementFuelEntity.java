package com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.Entity.MovementFuel;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.Fuel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity(name = "movement_fuel")
@Data
public class MovementFuelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull
    private MovementFuelEnum type;
    @NotNull
    private Fuel fuel;
    @NotNull
    private Double value;

    @Column(name = "value_total")
    private Double valueTotal;

    @CreationTimestamp
    @Column(name = "create_at")
    private LocalDateTime createAt;
    @NotNull
    private Double liters;
    @NotNull
    private int bomb;
    @NotNull
    @Column(name = "time_bomb")
    private Double timeBomb;

}
