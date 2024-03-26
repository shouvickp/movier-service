package dev.shouvick.movier.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.shouvick.movier.model.Review;
import dev.shouvick.movier.service.ReviewService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/reviews")
@AllArgsConstructor
public class ReviewController {

	private final ReviewService reviewService;

	@PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {

        return ResponseEntity.ok().body(reviewService.createReview(payload.get("reviewBody"), payload.get("imdbId")));
    }

}
