package com.proyecto.aj_solutions.Services;

import com.proyecto.aj_solutions.Interfaces.IRoleService;
import com.proyecto.aj_solutions.Models.Role;
import com.proyecto.aj_solutions.Repositorys.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements IRoleService {

    @Autowired
    private RoleRepository roleRepository;

    // Comprobar si un Rol existe en Base de datos
    public boolean existsRole(String name){
        return roleRepository.existsByName(name);
    }

    // Crear un nuevo Rol
    public void createRole(Role role){
        roleRepository.save(role);
    }

    // Obtener un Rol por su nombre
    public Role getRole(String name){
        return roleRepository.findRoleByName(name);
    }

    // Obtener todos los roles
    public List<Role> getAllRole(String name){
        return roleRepository.findByName(name);
    }
}
