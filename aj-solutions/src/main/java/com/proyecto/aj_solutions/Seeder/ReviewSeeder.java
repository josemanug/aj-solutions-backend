package com.proyecto.aj_solutions.Seeder;

import com.proyecto.aj_solutions.Models.Review;
import com.proyecto.aj_solutions.Models.User;
import com.proyecto.aj_solutions.Repositorys.ReviewRepository;
import com.proyecto.aj_solutions.Repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ReviewSeeder implements CommandLineRunner {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        seedReviews();
    }

    private void seedReviews() {
        Review review = new Review();

        review.setTitulo("Buenísimo");
        review.setDescripcion("He recibido un trato increíble y el color de mi pelo de maravilloso");
        review.setValoracion(5);
        review.setCliente(userRepository.findByUsername("cliente1"));

        reviewRepository.save(review);
    }
}
