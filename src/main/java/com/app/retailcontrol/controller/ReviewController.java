package com.app.retailcontrol.controller;

import com.app.retailcontrol.dto.ReviewDTO;
import com.app.retailcontrol.entity.Review;
import com.app.retailcontrol.repository.ReviewRepository;
import com.app.retailcontrol.service.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;
    private final ReviewRepository reviewRepository;

    public ReviewController(ReviewService reviewService, ReviewRepository reviewRepository) {
        this.reviewService = reviewService;
        this.reviewRepository = reviewRepository;
    }

    @GetMapping("/{storeId}/{productId}")
    public Map<String, Object> getReviews(@PathVariable Long storeId, @PathVariable Long productId) {
        Map<String, Object> apiResponse = new HashMap<>();
        List<ReviewDTO> reviews = reviewService.getReviewsDto(storeId, productId);
        apiResponse.put("reviews", reviews);
        return apiResponse;
    }

    @PostMapping
    public Map<String, String> addReview(@RequestBody Review review) {
        Map<String, String> apiResponse = new HashMap<>();
        reviewRepository.save(review);
        apiResponse.put("message", "Review saved successfully");
        return apiResponse;
    }

}
