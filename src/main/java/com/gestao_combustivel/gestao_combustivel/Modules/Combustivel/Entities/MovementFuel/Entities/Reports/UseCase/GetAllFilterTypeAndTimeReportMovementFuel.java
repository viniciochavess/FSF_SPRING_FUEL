package com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.Entities.MovementFuel.Entities.Reports.UseCase;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.Entities.MovementFuel.MovementFuelEntity;
import com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.Entities.MovementFuel.MovementFuelEnum;
import com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.Entities.MovementFuel.Entities.Reports.Repositories.ReportMovementFuelRepository;

@Service
public class GetAllFilterTypeAndTimeReportMovementFuel {

    @Autowired
    private ReportMovementFuelRepository reportMovementFuelRepository;

    public List<MovementFuelEntity> execute(String fuel, LocalDateTime dateStart, LocalDateTime dateEnd) {

        List<MovementFuelEntity> results = reportMovementFuelRepository.findByFuelAndTypeAndCreateAtBetween(fuel,
                MovementFuelEnum.VENDA,
                dateStart, dateEnd);
        return results;
    }
}
