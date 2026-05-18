package com.proyecto.aj_solutions.Controllers;

import com.proyecto.aj_solutions.Interfaces.ICitaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CitaController {

    private final ICitaService citaService;

    public CitaController(ICitaService citaService) {
        this.citaService = citaService;
    }

    @GetMapping("/citas")
    public ResponseEntity<?> findAllByEmpleado(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(citaService.findAllByEmpleado());
    }
}
