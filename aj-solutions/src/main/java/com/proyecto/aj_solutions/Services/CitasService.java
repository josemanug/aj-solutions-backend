package com.proyecto.aj_solutions.Services;

import com.proyecto.aj_solutions.DTOs.CIta.CitaResponse;
import com.proyecto.aj_solutions.Interfaces.ICitaService;
import com.proyecto.aj_solutions.Models.Reserva;
import com.proyecto.aj_solutions.Models.User;
import com.proyecto.aj_solutions.Repositorys.ReservaRepository;
import com.proyecto.aj_solutions.Repositorys.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CitasService implements ICitaService {

    private final ReservaRepository reservaRepository;
    private final UserRepository userRepository;

    public CitasService(ReservaRepository reservaRepository, UserRepository userRepository) {
        this.reservaRepository = reservaRepository;
        this.userRepository = userRepository;
    }

    public List<CitaResponse> findAllByEmpleado(){
        Authentication auth = SecurityContextHolder
                .getContext().getAuthentication();

        String username = auth.getName();

        User empleado = userRepository.findByUsername(username);

        List<Reserva> reservas = reservaRepository.findAll();

        return reservas.stream()
                .map(this::mapToCitaResponse)
                .collect(Collectors.toList());
    }

    private CitaResponse mapToCitaResponse(Reserva reserva) {
        return new CitaResponse(
                reserva.getUser().getFullName(),
                reserva.getService().getNombre(),
                reserva.getDate(),
                reserva.getTime()
        );
    }
}
