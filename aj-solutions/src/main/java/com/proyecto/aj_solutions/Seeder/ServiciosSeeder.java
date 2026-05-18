package com.proyecto.aj_solutions.Seeder;

import com.proyecto.aj_solutions.Models.Servicio;
import com.proyecto.aj_solutions.Models.User;
import com.proyecto.aj_solutions.Repositorys.ServicioRepository;
import com.proyecto.aj_solutions.Repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/*
*  SEEDER PARA LOS SERVICIOS QUE SE OFREZCAN
*/

@Component
@Order(2)
public class ServiciosSeeder implements CommandLineRunner {

    // Inyección de dependencias
    @Autowired
    private ServicioRepository servicioRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        seedServicios();
    }

    private void seedServicios() {
        if(!servicioRepository.existsByNombre("Servicio A")){
            Servicio servicio = new Servicio(
                    new BigDecimal("35.50"),
                    "Servicio A",
                    120,
                    "Descripción del Servicio A",
                    userRepository.findAllByUsername("empleado1")
            );
            servicioRepository.save(servicio);
        }

        if(!servicioRepository.existsByNombre("Servicio B")){
            Servicio servicio = new Servicio(
                    new BigDecimal("15.00"),
                    "Servicio B",
                    20,
                    "Descripción del Servicio B",
                    userRepository.findAllByUsername("empleado1")
            );
            servicioRepository.save(servicio);
        }

        if(!servicioRepository.existsByNombre("Servicio C")){
            Servicio servicio = new Servicio(
                    new BigDecimal("25.00"),
                    "Servicio C",
                    90,
                    "Descripción del Servicio C",
                    userRepository.findAllByUsername("empleado2")
            );
            servicioRepository.save(servicio);
        }

        if(!servicioRepository.existsByNombre("Servicio D")){
            Servicio servicio = new Servicio(
                    new BigDecimal("10.00"),
                    "Servicio D",
                    20,
                    "Descripción del Servicio D",
                    userRepository.findAllByUsername("empleado2")
            );
            servicioRepository.save(servicio);
        }
    }
}
