package com.proyecto.aj_solutions.Services;

import com.proyecto.aj_solutions.DTOs.Servicio.ServicioCreateRequest;
import com.proyecto.aj_solutions.DTOs.Servicio.ServicioResponse;
import com.proyecto.aj_solutions.DTOs.Servicio.ServicioUpdateRequest;
import com.proyecto.aj_solutions.DTOs.Servicio.ServicioUpdateResponse;
import com.proyecto.aj_solutions.Interfaces.IServicioService;
import com.proyecto.aj_solutions.Models.Servicio;
import com.proyecto.aj_solutions.Repositorys.ServicioRepository;
import com.proyecto.aj_solutions.Repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiciosService implements IServicioService {

    // Inección de dependencias
    @Autowired
    private ServicioRepository servicioRepository;

    @Autowired
    private UserRepository userRepository;

    // Lista con todos los servicios
    public List<ServicioResponse> findAll(){
        return servicioRepository.findAll().stream()
                .map(this::maptoServicioResponse)
                .collect(Collectors.toList());
    }

    // Detalles de un servicio

    public ServicioResponse findById(int id){
        return maptoServicioResponse(servicioRepository.findById(id).orElseThrow());
    }

    // Crear nuevos servicios
    public ServicioResponse createServicio(ServicioCreateRequest servicioCreateRequest){
        Servicio servicio = new Servicio();

        servicio.setNombre(servicioCreateRequest.nombre());
        servicio.setPrecio(servicioCreateRequest.precio());
        servicio.setDuracion(servicioCreateRequest.duracion());
        servicio.setEmpleado(userRepository.findAllByUsername(servicioCreateRequest.username()));

        servicioRepository.save(servicio);

        return maptoServicioResponse(servicio);
    }

    // Actualizar los servicios

    public ServicioUpdateResponse updateService(ServicioUpdateRequest servicioUpdateRequest){
        Servicio servicio = servicioRepository.findById(servicioUpdateRequest.id())
                .orElseThrow();

        servicio.setNombre(servicioUpdateRequest.nombre());
        servicio.setDescripcion(servicioUpdateRequest.descripcion());
        servicio.setDuracion(servicioUpdateRequest.duracion());
        servicio.setPrecio(servicioUpdateRequest.precio());

        servicioRepository.save(servicio);

        return maptoServicioUpdateResponse(servicio);
    }

    // Borrar un servicio
    public void deleteServicio(int id){
        Servicio servicio = servicioRepository.findById(id)
                .orElseThrow();

        servicioRepository.delete(servicio);
    }

    // Mappers

    private ServicioResponse maptoServicioResponse(Servicio servicio) {
        return new ServicioResponse(
                servicio.getId(),
                servicio.getNombre(),
                servicio.getPrecio(),
                servicio.getDuracion(),
                servicio.getDescripcion()
        );
    }

    private ServicioUpdateResponse maptoServicioUpdateResponse(Servicio servicio){
        return new ServicioUpdateResponse(
                servicio.getId(),
                servicio.getNombre(),
                servicio.getPrecio(),
                servicio.getDuracion(),
                servicio.getDescripcion()
        );
    }
}
