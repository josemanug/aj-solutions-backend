package com.proyecto.aj_solutions.Services;

import com.proyecto.aj_solutions.DTOs.Register.RegisterRequest;
import com.proyecto.aj_solutions.DTOs.Register.RegisterResponse;
import com.proyecto.aj_solutions.DTOs.User.UserResponse;
import com.proyecto.aj_solutions.DTOs.User.UserWithRoleResponse;
import com.proyecto.aj_solutions.Interfaces.IUserService;
import com.proyecto.aj_solutions.Models.Role;
import com.proyecto.aj_solutions.Models.User;
import com.proyecto.aj_solutions.Repositorys.RoleRepository;
import com.proyecto.aj_solutions.Repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class UserService implements UserDetailsService, IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getRoles().stream()
                        .map(role ->
                                new SimpleGrantedAuthority(role.getName()))
                        .toList()
        );
    }

    // Comprobar si existe un usuario
    public boolean existsByUsername(String username){
        return userRepository.existsByUsername(username);
    }

    // Crear un usuario a través de Seeder
    public void createUserBySeeder(User user){
        userRepository.save(user);
    }

    public RegisterResponse createUserClient(RegisterRequest registerRequest){
        User user = new User();

        user.setEmail(registerRequest.email());
        user.setFullName(registerRequest.fullName());
        user.setPassword(new BCryptPasswordEncoder().encode(registerRequest.password()));
        user.setPhone(registerRequest.phone());
        user.setUsername(registerRequest.username());
        user.setRoles(roleRepository.findByName("ROLE_CLIENTE"));

        userRepository.save(user);

        return maptoRegisterResponse(user);

    }

    public RegisterResponse createUserEmpelado(RegisterRequest registerRequest){
        User user = new User();

        user.setEmail(registerRequest.email());
        user.setFullName(registerRequest.fullName());
        user.setPassword(new BCryptPasswordEncoder().encode(registerRequest.password()));
        user.setPhone(registerRequest.phone());
        user.setUsername(registerRequest.username());
        user.setRoles(roleRepository.findByName("ROLE_EMPLEADO"));

        userRepository.save(user);

        return maptoRegisterResponse(user);

    }

    public List<UserWithRoleResponse> findAll(){
        return userRepository.findAll().stream()
                .map(this::mapToUserWithRoleResponse)
                .collect(toList());
    }

    public void deleteUser(int id){
        userRepository.deleteById(id);
    }


    private UserWithRoleResponse mapToUserWithRoleResponse(User user) {
        List<String> rolename = user.getRoles()
                .stream()
                .map(Role::getName)
                .toList();

        return new UserWithRoleResponse(
                user.getUserId(),
                user.getEmail(),
                user.getUsername(),
                user.getFullName(),
                user.getPhone(),
                rolename
        );

    }

    private RegisterResponse maptoRegisterResponse(User user) {
        return  new RegisterResponse(
                user.getEmail(),
                user.getUsername(),
                user.getPassword(),
                user.getFullName(),
                user.getPhone()
        );
    }
}
