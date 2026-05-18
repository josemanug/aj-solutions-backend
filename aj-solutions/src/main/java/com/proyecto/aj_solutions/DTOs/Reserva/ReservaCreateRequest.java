package com.proyecto.aj_solutions.DTOs.Reserva;

import java.time.LocalDate;
import java.time.LocalTime;

public record ReservaCreateRequest(
        int serviceId,
        LocalDate date,
        LocalTime time
) {
}
