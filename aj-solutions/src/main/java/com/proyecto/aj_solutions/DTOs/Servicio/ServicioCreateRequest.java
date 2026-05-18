package com.proyecto.aj_solutions.DTOs.Servicio;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public record ServicioCreateRequest(
        @NotBlank(message = "Este campo no puede estar en blanco")
        String nombre,

        @NotNull
        @Digits(integer = 3, fraction = 2)
        BigDecimal precio,

        @NotNull
        int duracion,

        @NotNull
        String descripcion,

        String username
) {}
