package com.proyecto.aj_solutions.Controllers;

import com.proyecto.aj_solutions.DTOs.Login.LoginRequest;
import com.proyecto.aj_solutions.DTOs.Login.LoginResponse;
import com.proyecto.aj_solutions.DTOs.Register.RegisterRequest;
import com.proyecto.aj_solutions.Interfaces.IUserService;
import com.proyecto.aj_solutions.Services.JwtService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private IUserService userService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest){
        Authentication authentication =
                new UsernamePasswordAuthenticationToken(
                        loginRequest.username(),
                        loginRequest.password()
                );

        Authentication authResult =
                authenticationManager.authenticate(authentication);

        UserDetails userDetails =
                (UserDetails) authResult.getPrincipal();

        String token = jwtService.generateToken(userDetails);

        return new LoginResponse(token);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerClient(@Valid @RequestBody RegisterRequest registerRequest){
        try {
            userService.createUserClient(registerRequest);
            return ResponseEntity
                    .status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity
                    .badRequest().build();
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/registerEmpleado")
    public ResponseEntity<?> registerEmpleado(@Valid @RequestBody RegisterRequest registerRequest){
        try {
            userService.createUserEmpelado(registerRequest);
            return ResponseEntity
                    .status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity
                    .badRequest().build();
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/users")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.findAll());
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id){
        try {
            userService.deleteUser(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e);
        }
    }
}
