package com.proyecto.aj_solutions.Interfaces;

import com.proyecto.aj_solutions.DTOs.Servicio.ServicioCreateRequest;
import com.proyecto.aj_solutions.DTOs.Servicio.ServicioResponse;
import com.proyecto.aj_solutions.DTOs.Servicio.ServicioUpdateRequest;
import com.proyecto.aj_solutions.DTOs.Servicio.ServicioUpdateResponse;

import java.util.List;

public interface IServicioService {

    List<ServicioResponse> findAll();

    ServicioResponse findById(int id);

    ServicioResponse createServicio(ServicioCreateRequest servicioCreateRequest);

    ServicioUpdateResponse updateService(ServicioUpdateRequest servicioUpdateRequest);

    void deleteServicio(int id);
}
