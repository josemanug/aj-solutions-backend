package com.proyecto.aj_solutions.Seeder;

import com.proyecto.aj_solutions.Interfaces.IRoleService;
import com.proyecto.aj_solutions.Interfaces.IUserService;
import com.proyecto.aj_solutions.Models.Role;
import com.proyecto.aj_solutions.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/*
    SEEDER DE USUARIOS Y ROLES
 */

@Component
@Order(1)
public class UserRoleSeeder implements CommandLineRunner {

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IUserService userService;

    @Override
    public void run(String... args) throws Exception {
        seedRole();
        seedUser();
    }

    // Seeder de los usuarios
    private void seedUser() {

        // Usuario Administrador
        if(!userService.existsByUsername("Administrador")) {
            userService.createUserBySeeder(new User(
                    "admin@ajsolutions.com", // email
                    "administrador", // username
                    new BCryptPasswordEncoder().encode("Admin123!"), // password
                    "Administrador", // nombre completo
                    "123456789", // Número de teléfono
                    roleService.getAllRole("ROLE_ADMIN")
            ));
        }

        // Dos empleados
        if(!userService.existsByUsername("Empleado1")) {
            userService.createUserBySeeder(new User(
                    "empleado1@ajsolutions.com", // email
                    "empleado1", // username
                    new BCryptPasswordEncoder().encode("Empleado123!"), // password
                    "Empleado1", // nombre completo
                    "234567891", // Número de teléfono
                    roleService.getAllRole("ROLE_EMPLEADO")
            ));
        }
        if(!userService.existsByUsername("Empleado2")) {
            userService.createUserBySeeder(new User(
                    "empleado2@ajsolutions.com", // email
                    "empleado2", // username
                    new BCryptPasswordEncoder().encode("Empleado123!"), // password
                    "Empleado2", // nombre completo
                    "345678912", // Número de teléfono
                    roleService.getAllRole("ROLE_EMPLEADO")
            ));
        }

        // Dos Clientes
        if(!userService.existsByUsername("cliente1")) {
            userService.createUserBySeeder(new User(
                    "cliente1@ajsolutions.com", // email
                    "cliente1", // username
                    new BCryptPasswordEncoder().encode("Cliente123!"), // password
                    "Cliente1", // nombre completo
                    "456789123", // Número de teléfono
                    roleService.getAllRole("ROLE_CLIENTE")
            ));
        }
        if(!userService.existsByUsername("cliente2")) {
            userService.createUserBySeeder(new User(
                    "cliente2@ajsolutions.com", // email
                    "cliente2", // username
                    new BCryptPasswordEncoder().encode("Cliente123!"), // password
                    "cliente2", // nombre completo
                    "567891234", // Número de teléfono
                    roleService.getAllRole("ROLE_CLIENTE")
            ));
        }
    }


    // Seeder de los roles
    private void seedRole() {

        // Rol para los clientes
        if(!roleService.existsRole("ROLE_CLIENTE")){
            roleService.createRole(new Role("ROLE_CLIENTE"));
        }

        // Rol para los empleados
        if(!roleService.existsRole("ROLE_EMPLEADO")){
            roleService.createRole(new Role("ROLE_EMPLEADO"));
        }

        // Rol para el Admin
        if(!roleService.existsRole("ROLE_ADMIN")){
            roleService.createRole(new Role("ROLE_ADMIN"));
        }
    }
}
