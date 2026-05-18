package com.proyecto.aj_solutions.Repositorys;

import com.proyecto.aj_solutions.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    boolean existsByName(String name);

    List<Role> findByName(String name);

    Role findRoleByName(String name);
}
