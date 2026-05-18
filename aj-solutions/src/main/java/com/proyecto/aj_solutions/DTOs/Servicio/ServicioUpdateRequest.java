package com.proyecto.aj_solutions.DTOs.Servicio;

import jakarta.validation.constraints.Digits;

import java.math.BigDecimal;

public record ServicioUpdateRequest(

        int id,

        String nombre,

        @Digits(integer = 3, fraction = 2)
        BigDecimal precio,

        int duracion,

        String descripcion
) {}
