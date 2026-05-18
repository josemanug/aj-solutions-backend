package com.proyecto.aj_solutions.Interfaces;

import com.proyecto.aj_solutions.DTOs.Reserva.ReservaCreateRequest;
import com.proyecto.aj_solutions.Models.Reserva;

public interface IReservaService {

    Reserva crearReserva(ReservaCreateRequest reservaCreateRequest);
}
