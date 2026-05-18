package com.proyecto.aj_solutions.Services;

import com.proyecto.aj_solutions.DTOs.Review.ReviewResponse;
import com.proyecto.aj_solutions.DTOs.Review.createReviewRequest;
import com.proyecto.aj_solutions.DTOs.Review.createReviewResponse;
import com.proyecto.aj_solutions.DTOs.User.UserResponse;
import com.proyecto.aj_solutions.Interfaces.IReviewService;
import com.proyecto.aj_solutions.Models.Review;
import com.proyecto.aj_solutions.Repositorys.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService implements IReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    // Listar todas las Reviews
    public List<ReviewResponse> findAll(){
        return reviewRepository.findAll().stream()
                .map(this::maptoReviewResponse)
                .collect(Collectors.toList());
    }

    public ReviewResponse findById(int id){
        Review review = reviewRepository.findById(id)
                .orElseThrow();

        return maptoReviewResponse(review);
    }

    public createReviewResponse createReview(createReviewRequest createReviewRequest) {
        Review review = new Review();

        review.setTitulo(createReviewRequest.titulo());
        review.setDescripcion(createReviewRequest.descripcion());
        review.setValoracion(createReviewRequest.valoracion());

        reviewRepository.save(review);

        return mapToCreateReviewResponse(review);
    }

    // Mapper
    private ReviewResponse maptoReviewResponse(Review review) {
        return new ReviewResponse(
                review.getTitulo(),
                review.getDescripcion(),
                review.getValoracion(),
                new UserResponse(
                        review.getCliente().getUserId(),
                        review.getCliente().getEmail(),
                        review.getCliente().getUsername(),
                        review.getCliente().getFullName(),
                        review.getCliente().getPhone()
                )
        );
    }

    private createReviewResponse mapToCreateReviewResponse(Review review) {

        return new createReviewResponse(
                review.getTitulo(),
                review.getDescripcion(),
                review.getValoracion(),
                new UserResponse(
                        review.getCliente().getUserId(),
                        review.getCliente().getEmail(),
                        review.getCliente().getUsername(),
                        review.getCliente().getFullName(),
                        review.getCliente().getPhone()
                )
        );
    }
}
