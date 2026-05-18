package com.proyecto.aj_solutions.DTOs.User;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record UserResponse(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        int userId,

        @Email
        String email,

        @NotBlank
        String username,

        @NotBlank
        String fullName,

        @NotBlank
        @Length(min = 9, max = 9, message = "Este campo debe contener 9 dígitos.")
        String phone
) {}
