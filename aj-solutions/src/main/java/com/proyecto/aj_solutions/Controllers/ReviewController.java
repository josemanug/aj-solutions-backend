package com.proyecto.aj_solutions.Controllers;

 import com.proyecto.aj_solutions.DTOs.Review.createReviewRequest;
 import com.proyecto.aj_solutions.Interfaces.IReviewService;
 import jakarta.validation.Valid;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.http.HttpStatus;
 import org.springframework.http.ResponseEntity;
 import org.springframework.security.access.prepost.PreAuthorize;
 import org.springframework.validation.BindingResult;
 import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ReviewController {

    @Autowired
    private IReviewService reviewService;


    // Listar todas las reseñas
    @PreAuthorize("hasAnyRole('ROLE_CLIENTE','ROLE_EMPLEADO', 'ROLE_ADMIN')")
    @GetMapping("/review")
    public ResponseEntity<?> findAll(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(reviewService.findAll());
    }

    // Ver detalles de una Review
    @PreAuthorize("hasAnyRole('ROLE_CLIENTE','ROLE_EMPLEADO', 'ROLE_ADMIN')")
    @GetMapping("/review/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(reviewService.findById(id));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Review no encontrada");
        }
    }

    // Crear una review
    @PreAuthorize("hasRole('ROLE_CLIENTE')")
    @PostMapping("/review")
    public ResponseEntity<?> createReview(@Valid @RequestBody createReviewRequest createReviewRequest, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(bindingResult.getAllErrors());
        }
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(reviewService.createReview(createReviewRequest));

    }
}
