package com.proyecto.aj_solutions.Interfaces;

import com.proyecto.aj_solutions.DTOs.Register.RegisterRequest;
import com.proyecto.aj_solutions.DTOs.Register.RegisterResponse;
import com.proyecto.aj_solutions.DTOs.User.UserResponse;
import com.proyecto.aj_solutions.DTOs.User.UserWithRoleResponse;
import com.proyecto.aj_solutions.Models.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface IUserService {

    UserDetails loadUserByUsername(String username);

    boolean existsByUsername(String username);

    void createUserBySeeder(User user);

    RegisterResponse createUserClient(RegisterRequest registerRequest);

    RegisterResponse createUserEmpelado(RegisterRequest registerRequest);

    List<UserWithRoleResponse> findAll();

    void deleteUser(int id);
}
