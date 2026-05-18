package com.proyecto.aj_solutions.Interfaces;

import com.proyecto.aj_solutions.DTOs.Review.ReviewResponse;
import com.proyecto.aj_solutions.DTOs.Review.createReviewRequest;
import com.proyecto.aj_solutions.DTOs.Review.createReviewResponse;

import java.util.List;

public interface IReviewService {

    List<ReviewResponse> findAll();

    ReviewResponse findById(int id);

    createReviewResponse createReview(createReviewRequest createReviewRequest);
}
