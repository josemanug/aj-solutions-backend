package com.proyecto.aj_solutions.Controllers;

import com.proyecto.aj_solutions.DTOs.Reserva.ReservaCreateRequest;
import com.proyecto.aj_solutions.Interfaces.IReservaService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ReservaController {

    private final IReservaService reservaService;

    public ReservaController(IReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping("/reservar")
    public ResponseEntity<?> createReserva(@RequestBody ReservaCreateRequest reservaCreateRequest, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(bindingResult.getAllErrors());
        }

        return ResponseEntity.ok(
                reservaService.crearReserva(reservaCreateRequest)
        );
    }
}
