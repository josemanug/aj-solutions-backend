package com.proyecto.aj_solutions.DTOs.CIta;

import com.proyecto.aj_solutions.Models.Servicio;
import com.proyecto.aj_solutions.Models.User;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import java.time.LocalTime;

public record CitaResponse (

        String user,

        String service,

        @Column(nullable = false)
        LocalDate date,

        @Column(nullable = false)
        LocalTime time
) {
}
