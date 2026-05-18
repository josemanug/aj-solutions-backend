package com.proyecto.aj_solutions.DTOs.Login;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record LoginRequest(
        @NotEmpty(message = "Este campo no puede estar vacío")
        @NotNull(message = "Este campo no puede ser nulo")
        @Size(min = 1, max = 100, message = "El tamaño debe estar entre 1 y 100 caracteres")
        String username,

        @NotEmpty(message = "Este campo no puede estar vacío")
        @NotNull(message = "Este campo no puede ser nulo")
        @Size(min = 1, max = 100, message = "El tamaño debe estar entre 1 y 100 caracteres")
        String password
) {}
