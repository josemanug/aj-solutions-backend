package com.proyecto.aj_solutions.Repositorys;

import com.proyecto.aj_solutions.Models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
