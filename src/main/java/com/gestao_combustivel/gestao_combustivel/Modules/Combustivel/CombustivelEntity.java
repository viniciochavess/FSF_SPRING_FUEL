package com.gestao_combustivel.gestao_combustivel.Modules.Combustivel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "combustivel")
public class CombustivelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double currentValue;
    private Double total_liters;
    private Fuel fuel;
}
