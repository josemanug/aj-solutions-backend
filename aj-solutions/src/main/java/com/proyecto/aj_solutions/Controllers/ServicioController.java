package com.proyecto.aj_solutions.Controllers;

import com.proyecto.aj_solutions.DTOs.Servicio.ServicioCreateRequest;
import com.proyecto.aj_solutions.DTOs.Servicio.ServicioUpdateRequest;
import com.proyecto.aj_solutions.Interfaces.IServicioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ServicioController {

    // Inyección de dependencias
    @Autowired
    private IServicioService servicioService;

    // Obtener todos los servicios
    @PreAuthorize("hasAnyRole('ROLE_CLIENTE','ROLE_EMPLEADO', 'ROLE_ADMIN')")
    @GetMapping("/servicios")
    public ResponseEntity<?> findAll(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(servicioService.findAll());
    }

    // Detalles de un Servicio
    @PreAuthorize("hasAnyRole('ROLE_CLIENTE','ROLE_EMPLEADO', 'ROLE_ADMIN')")
    @GetMapping("/servicios/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(servicioService.findById(id));
        } catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Servicio no encontrado");
        }
    }

    // Crear un servicio
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/servicios")
    public ResponseEntity<?> createServicio(@Valid @RequestBody ServicioCreateRequest servicioCreateRequest, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(bindingResult.getAllErrors());
        } else {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(servicioService.createServicio(servicioCreateRequest));
        }
    }

    // Actualizar un servicio
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/servicios")
    public ResponseEntity<?> updateServicio(@Valid @RequestBody ServicioUpdateRequest servicioUpdateRequest, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(bindingResult.getAllErrors());
        } else {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(servicioService.updateService(servicioUpdateRequest));
        }
    }

    // Borrar un servicio
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/servicios/{id}")
    public ResponseEntity<?> deleteServicio(@PathVariable int id){
        try {
            servicioService.deleteServicio(id);
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .build();
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Servicio no encontrado");
        }
    }
}
