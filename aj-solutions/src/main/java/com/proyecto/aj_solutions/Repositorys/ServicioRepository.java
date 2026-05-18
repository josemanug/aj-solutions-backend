package com.proyecto.aj_solutions.Repositorys;

import com.proyecto.aj_solutions.Models.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Integer> {
    boolean existsByNombre(String nombre);

    Servicio findByNombre(String nombre);
}
