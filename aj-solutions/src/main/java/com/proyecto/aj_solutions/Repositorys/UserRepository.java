package com.proyecto.aj_solutions.Repositorys;

import com.proyecto.aj_solutions.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);

    boolean existsByUsername(String username);

    List<User> findAllByUsername(String username);
}
