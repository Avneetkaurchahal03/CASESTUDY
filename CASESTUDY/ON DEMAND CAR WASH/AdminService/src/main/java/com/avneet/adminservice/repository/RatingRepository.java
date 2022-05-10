package com.avneet.adminservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.avneet.adminservice.model.WasherRating;

@Repository
public interface RatingRepository extends MongoRepository<WasherRating, String>{

}
