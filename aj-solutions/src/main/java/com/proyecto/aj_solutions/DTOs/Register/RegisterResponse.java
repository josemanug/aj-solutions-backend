package com.proyecto.aj_solutions.DTOs.Register;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record RegisterResponse(

        @Email
        String email,

        @NotBlank
        String username,

        @NotBlank
        String password,

        @NotBlank
        String fullName,

        @NotBlank
        @Length(min = 9, max = 9, message = "Este campo debe contener 9 dígitos.")
        String phone
) {}
