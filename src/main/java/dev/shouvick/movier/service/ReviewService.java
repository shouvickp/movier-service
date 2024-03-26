package dev.shouvick.movier.service;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import dev.shouvick.movier.model.Movie;
import dev.shouvick.movier.model.Review;
import dev.shouvick.movier.repository.ReviewRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReviewService {
	private final ReviewRepository reviewRepository;	

	private final MongoTemplate mongoTemplate;

	public Review createReview(String reviewBody, String imdbId) {
        Review review = reviewRepository.insert(Review.builder().body(reviewBody).created(LocalDateTime.now()).updated(LocalDateTime.now()).build());

        mongoTemplate.update(Movie.class)
            .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviews").value(review.getId()))
                .first();
        return review;
    }
}
