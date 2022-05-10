package com.avneet.review.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.avneet.review.model.ReviewAndRatings;

public interface ReviewAndRatingsRepository extends MongoRepository<ReviewAndRatings, Integer> {

}
