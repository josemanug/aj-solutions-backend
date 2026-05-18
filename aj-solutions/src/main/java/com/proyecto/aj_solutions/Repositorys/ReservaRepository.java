package com.proyecto.aj_solutions.Repositorys;

import com.proyecto.aj_solutions.Models.Reserva;
import com.proyecto.aj_solutions.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
}
