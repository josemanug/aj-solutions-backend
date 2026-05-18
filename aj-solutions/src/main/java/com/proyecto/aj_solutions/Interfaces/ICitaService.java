package com.proyecto.aj_solutions.Interfaces;

import com.proyecto.aj_solutions.DTOs.CIta.CitaResponse;
import com.proyecto.aj_solutions.Models.Reserva;

import java.util.List;

public interface ICitaService {

    List<CitaResponse> findAllByEmpleado();
}
