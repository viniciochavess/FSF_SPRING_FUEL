package com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.Communications;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateValueJSON {
    @NotNull
    private Double value;
    @NotNull
    private String name;

}
