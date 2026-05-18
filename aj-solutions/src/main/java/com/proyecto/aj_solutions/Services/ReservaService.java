package com.proyecto.aj_solutions.Services;

import com.proyecto.aj_solutions.DTOs.Reserva.ReservaCreateRequest;
import com.proyecto.aj_solutions.Interfaces.IReservaService;
import com.proyecto.aj_solutions.Models.Reserva;
import com.proyecto.aj_solutions.Models.Servicio;
import com.proyecto.aj_solutions.Models.User;
import com.proyecto.aj_solutions.Repositorys.ReservaRepository;
import com.proyecto.aj_solutions.Repositorys.ServicioRepository;
import com.proyecto.aj_solutions.Repositorys.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class ReservaService implements IReservaService {

    private final ReservaRepository reservaRepository;
    private final UserRepository userRepository;
    private final ServicioRepository servicioRepository;

    public ReservaService(ReservaRepository reservaRepository, UserRepository userRepository, ServicioRepository servicioRepository) {
        this.reservaRepository = reservaRepository;
        this.userRepository = userRepository;
        this.servicioRepository = servicioRepository;
    }

    public Reserva crearReserva(ReservaCreateRequest reservaCreateRequest){

        Authentication auth = SecurityContextHolder
                .getContext().getAuthentication();

        String username = auth.getName();

        User user = userRepository.findByUsername(username);

        Servicio service = servicioRepository.findById(reservaCreateRequest.serviceId())
                .orElseThrow(() -> new RuntimeException("Servicio no encontrado"));

        Reserva reservation = new Reserva();
        reservation.setUser(user);
        reservation.setService(service);
        reservation.setDate(reservaCreateRequest.date());
        reservation.setTime(reservaCreateRequest.time());

        return reservaRepository.save(reservation);
    }
}
