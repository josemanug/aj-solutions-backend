package com.proyecto.aj_solutions.Interfaces;

import com.proyecto.aj_solutions.Models.Role;

import java.util.List;

public interface IRoleService {

    boolean existsRole(String name);

    void createRole(Role role);

    Role getRole(String name);

    List<Role> getAllRole(String name);
}
