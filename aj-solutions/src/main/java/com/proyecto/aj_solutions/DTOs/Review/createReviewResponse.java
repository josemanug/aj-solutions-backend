package com.proyecto.aj_solutions.DTOs.Review;

import com.proyecto.aj_solutions.DTOs.User.UserResponse;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record createReviewResponse(
        @NotNull
        @NotBlank
        String titulo,

        @NotNull
        @NotBlank
        String descripcion,

        @NotNull
        @Min(value = 1, message = "Valoración mínima: 1")
        @Max(value = 5, message = "Valoración máxima: 5")
        int valoracion,

        UserResponse cliente
) {}
