package com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.Entities.MovementFuel.Entities.Reports.Controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.Entities.MovementFuel.MovementFuelEntity;
import com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.Entities.MovementFuel.Entities.Reports.UseCase.GetAllFilterTypeAndTimeReportMovementFuel;
import com.gestao_combustivel.gestao_combustivel.Modules.Combustivel.Entities.MovementFuel.Entities.Reports.UseCase.GetAllReportMovementFuel;

@Controller
@RequestMapping("/relatorio")
public class ReportMovementFuelController {

    @Autowired
    private GetAllReportMovementFuel getAllReportMovementFull;

    @Autowired
    private GetAllFilterTypeAndTimeReportMovementFuel getAllFilterTypeAndTimeReportMovementFuel;

    @GetMapping("")
    public ResponseEntity<List<MovementFuelEntity>> GetAll() {
        var result = this.getAllReportMovementFull.excecute();
        return ResponseEntity.ok().body(result);

    }

    @GetMapping("/fuel")

    public ResponseEntity<List<MovementFuelEntity>> GetAllFuel(
            @RequestParam String fuel,
            @RequestParam String startDateTime,
            @RequestParam String endDateTime) {

        try {

            LocalDateTime dateStart = LocalDateTime.parse(startDateTime);
            LocalDateTime dateEnd = LocalDateTime.parse(endDateTime);

            var result = getAllFilterTypeAndTimeReportMovementFuel.execute(fuel, dateStart, dateEnd);

            return ResponseEntity.ok().body(result);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }

    }

}
